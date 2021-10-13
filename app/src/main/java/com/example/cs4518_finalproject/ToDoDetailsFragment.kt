package com.example.cs4518_finalproject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

private const val TAG = "ToDoDetailsFragment"

class ToDoDetailsFragment : Fragment(){

    private val toDoDetailsViewModel: ToDoDetailsViewModel by lazy {
        ViewModelProviders.of(this).get(ToDoDetailsViewModel::class.java)
    }

    private lateinit var toDo: ToDo
    private lateinit var toDoTitle: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var makeToDo: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo_details, container, false)

        toDo = ToDo()

        toDoTitle = view.findViewById(R.id.toDoTitle) as EditText
        checkBox = view.findViewById(R.id.toDoComplete) as CheckBox
        makeToDo = view.findViewById(R.id.makeToDo) as Button

        fun makeNewToDo(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, ToDoFragment())
            transaction.addToBackStack(null)
            transaction.commit()

            toDoDetailsViewModel.addToDo(toDo)
        }

        val titleWatcher = object : TextWatcher {
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
            ) { toDo.title = sequence.toString() }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        toDoTitle.addTextChangedListener(titleWatcher)

        makeToDo.setOnClickListener{makeNewToDo()}

        return view
    }
}