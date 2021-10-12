package com.example.cs4518_finalproject

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

class AssignmentDetailsFragment : Fragment(){

    private val asgnDetailsViewModel: AssignmentDetailsViewModel by lazy {
        ViewModelProviders.of(this).get(AssignmentDetailsViewModel::class.java)
    }
}