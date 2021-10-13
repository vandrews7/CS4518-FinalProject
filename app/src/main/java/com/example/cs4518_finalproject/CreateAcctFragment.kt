package com.example.cs4518_finalproject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

class CreateAcctFragment : Fragment() {

    private val createAcctViewModel : CreateAcctViewModel by lazy {
        ViewModelProviders.of(this).get(CreateAcctViewModel::class.java)
    }

    private lateinit var user: User
    private lateinit var createAcctTxt: TextView
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var email: EditText
    private lateinit var birthday: EditText
    private lateinit var password: EditText
    private lateinit var create: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_account, container, false)

        fun loadHome(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        create = view.findViewById(R.id.createBtn) as Button
        createAcctTxt = view.findViewById(R.id.createAcctTxt) as TextView
        firstName = view.findViewById(R.id.firstName) as EditText
        lastName = view.findViewById(R.id.lastName) as EditText
        email = view.findViewById(R.id.inputEmail) as EditText
        birthday = view.findViewById(R.id.birthday) as EditText
        password = view.findViewById(R.id.newPassword) as EditText

        create.setOnClickListener { loadHome() }

        return view
    }

    override fun onStart() {
        super.onStart()

        val firstNameWatcher = object : TextWatcher {
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
                user.firstName = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        firstName.addTextChangedListener(firstNameWatcher)

        val lastNameWatcher = object : TextWatcher {
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
                user.lastName = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        lastName.addTextChangedListener(lastNameWatcher)

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
                user.email = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        email.addTextChangedListener(emailWatcher)

        val birthdayWatcher = object : TextWatcher {
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
                user.birthday = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        birthday.addTextChangedListener(birthdayWatcher)

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
                user.password = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        password.addTextChangedListener(passwordWatcher)
    }
}


