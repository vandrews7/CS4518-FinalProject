package com.example.cs4518_finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

class LoginFragment : Fragment() {

    private val loginViewModel : LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    private lateinit var loginTxt: TextView
    private lateinit var enterEmail: EditText
    private lateinit var enterPwd: EditText
    private lateinit var login: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        fun loadHome(){
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        loginTxt = view.findViewById(R.id.loginTxt) as TextView
        enterEmail = view.findViewById(R.id.editTextEmailAddress) as EditText
        enterPwd = view.findViewById(R.id.editTextPassword) as EditText
        login = view.findViewById(R.id.loginBtn) as Button

        //TODO: if email and pwd don't match existing user -> disable button
        //TODO: if email and pwd match existing user -> enable button:
        login.setOnClickListener {
            loadHome()
        }

        return view
    }

    override fun onStart() {
        super.onStart()


    }

}