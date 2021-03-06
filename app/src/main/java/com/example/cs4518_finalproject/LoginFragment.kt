package com.example.cs4518_finalproject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders

private const val TAG = "LoginFragment"

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
        var emailString: String = ""
        var passString: String = ""

        fun loadHome(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        loginTxt = view.findViewById(R.id.loginTxt) as TextView
        enterEmail = view.findViewById(R.id.editTextEmailAddress) as EditText
        enterPwd = view.findViewById(R.id.editTextPassword) as EditText
        login = view.findViewById(R.id.loginBtn) as Button


        val emailWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) { }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                emailString = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        enterEmail.addTextChangedListener(emailWatcher)

        val passwordWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) { }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                passString = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        enterPwd.addTextChangedListener(passwordWatcher)


        login.setOnClickListener {
            // authenticate login
            val loginValid: LiveData<User?> = loginViewModel.checkLogin(emailString, passString)
            loginValid.observe(
                viewLifecycleOwner,
                {
                    user -> user?.let {
                            Log.d(TAG, "login is valid")
                            loadHome()
                    }
                    if(user == null) {
                        Toast.makeText(
                            requireActivity(),
                            R.string.login_failed,
                            Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            )
        }

        return view
    }

    override fun onStart() {
        super.onStart()
    }

}