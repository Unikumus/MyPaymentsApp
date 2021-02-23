package com.unikumus.mypayments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unikumus.mypayments.models.LoginPostData
import com.unikumus.mypayments.repository.Repository
import com.unikumus.mypayments.ui.fragments.login.LoginViewModel
import com.unikumus.mypayments.ui.fragments.login.LoginViewModelFactory

class FragmentLogin : Fragment() {

    private lateinit var btnLogin : Button
    private lateinit var login : EditText
    private lateinit var password : EditText

    private lateinit var viewModel: LoginViewModel

    private lateinit var communicator: Communicator


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login1, container, false)
        btnLogin = view.findViewById(R.id.tvButton)
        login = view.findViewById(R.id.tvLogin)
        password = view.findViewById(R.id.tvPassword)

        communicator = activity as Communicator

        return view
    }

    override fun onStart() {
        super.onStart()
        val repository = Repository()
        val viewModelFactory =LoginViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory ).get(LoginViewModel::class.java)

        btnLogin.setOnClickListener {
            Log.d("Response", "print")
            formValidate()
        }


    }

    private fun formValidate(){
        if(login.text.toString().isEmpty()|| password.text.toString().isEmpty()){
           Toast.makeText(activity, "Введите логин или пароль", Toast.LENGTH_SHORT).show()
        } else{
            val loginPostData : LoginPostData =  LoginPostData(
                login = login.text.toString(),
                password = password.text.toString()
            )

            Log.d("Response", loginPostData.toString())

            viewModel.login(loginPostData)
            viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
                if(response.isSuccessful){
                    if(response.body()?.success == "true"){
                        response.body()?.response?.let { communicator.passDataCom(it.token) }
                    }
                    if(response.body()?.success == "false"){
                        Toast.makeText(activity, "Не правильный логин или пароль", Toast.LENGTH_SHORT).show()
                    }

                Log.d("Response", response.body()?.success!!)
                Log.d("Response", response.body()?.response.toString())
                }else{
                  Toast.makeText(activity, response.code(), Toast.LENGTH_SHORT).show()
//                Log.d("Response", response.errorBody().toString())
                }
            })

        }
    }

}