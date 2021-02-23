package com.unikumus.mypayments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.unikumus.mypayments.ui.adapters.MyAdapter
import com.unikumus.mypayments.repository.Repository
import com.unikumus.mypayments.ui.fragments.payments.PaymentsViewModel
import com.unikumus.mypayments.ui.fragments.payments.PaymentsViewModelFactory
import kotlinx.android.synthetic.main.fragment_payment_list.*

class FragmentPayments : Fragment() {

    private lateinit var viewModel: PaymentsViewModel
    private val myAdapter by lazy { MyAdapter() }
    var token:String? = ""

    private lateinit var progressbar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_payment_list, container, false)
        progressbar = view.findViewById(R.id.progressbar)
        return  view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        token = arguments?.getString("token")
        val repository = Repository()
        val viewModelFactory = PaymentsViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory ).get(PaymentsViewModel::class.java)
        viewModel.getPayments(token)
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
                progressbar.visibility = View.GONE;
            }else{
                Toast.makeText(activity, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }


}