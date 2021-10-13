package com.example.cs4518_finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import java.util.*


private const val TAG = "HomeFragment"

class HomeFragment : Fragment(){

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private lateinit var welcome: TextView
    private lateinit var calendarBtn: Button
    private lateinit var currentAsgnBtn: Button
    private lateinit var todoBtn: Button
    private lateinit var logout: Button
    private lateinit var photo: Button
    private lateinit var shared: Button
    private lateinit var currentDateTxt: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        fun logout(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, OpeningFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun loadCurrentAssignment(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, AssignmentListFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun loadCalendar(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, CalendarFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun loadToDo(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, ToDoFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun loadShared(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, SharedFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun loadPhoto() {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, PhotoFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        welcome = view.findViewById(R.id.welcomeTxt) as TextView
        calendarBtn = view.findViewById(R.id.calendarBtn) as Button
        currentAsgnBtn = view.findViewById(R.id.currentAssignmentsBtn) as Button
        todoBtn = view.findViewById(R.id.toDoBtn) as Button
        logout = view.findViewById(R.id.logoutBtn) as Button
        photo = view.findViewById(R.id.takePhotoBtn) as Button
        shared = view.findViewById(R.id.sharedBtn) as Button
        currentDateTxt = view.findViewById(R.id.homeCurrentDate) as TextView

        currentDateTxt.text = Date().toString()

        calendarBtn.setOnClickListener { loadCalendar() }
        currentAsgnBtn.setOnClickListener { loadCurrentAssignment() }
        todoBtn.setOnClickListener { loadToDo() }
        logout.setOnClickListener { logout() }
        shared.setOnClickListener { loadShared() }
        photo.setOnClickListener{ loadPhoto() }

        return view
    }

}