package com.example.cs4518_finalproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.vstechlab.easyfonts.EasyFonts
import org.w3c.dom.Text
import java.util.*

private const val TAG = "OpeningFragment"

class OpeningFragment: Fragment(){

    private val openingViewModel : OpeningViewModel by lazy {
        ViewModelProviders.of(this).get(OpeningViewModel::class.java)
    }

    private lateinit var appName: TextView
    private lateinit var createAcctBtn: Button
    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_opening, container, false)

        fun loadCreateAcct(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, CreateAcctFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun loadLogin(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, LoginFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        appName = view.findViewById(R.id.appName) as TextView
        createAcctBtn = view.findViewById(R.id.createAcctBtn) as Button
        loginBtn = view.findViewById(R.id.loginPageBtn) as Button

        appName.setTypeface(EasyFonts.androidNation(context))
        createAcctBtn.setOnClickListener { loadCreateAcct() }
        loginBtn.setOnClickListener { loadLogin() }


        return view
    }
}