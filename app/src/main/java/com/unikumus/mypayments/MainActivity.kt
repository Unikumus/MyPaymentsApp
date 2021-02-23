package com.unikumus.mypayments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginFragment = FragmentLogin()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.flFragment, loginFragment)
            .commit()
    }

    override fun passDataCom(token: String) {
      val bundle = Bundle()
        bundle.putString("token", token)

        val transaction = this.supportFragmentManager.beginTransaction()
        val paymentsFragment = FragmentPayments()
        paymentsFragment.arguments = bundle
        transaction.replace(R.id.flFragment, paymentsFragment)
        transaction.commit()


    }

}