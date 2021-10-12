package com.example.cs4518_finalproject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class AssignmentListFragment: Fragment(){

    private val assignmentViewModel: AssignmentViewModel by lazy {
        ViewModelProviders.of(this).get(AssignmentViewModel::class.java)
    }

    private lateinit var assignment: Assignment
    private lateinit var assignmentTitle: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var dueDateText: TextView
    private lateinit var editDate: EditText
    private lateinit var subjectText: EditText
    private lateinit var shareBtn: Button
    private lateinit var assignmentsTab: TextView
    private lateinit var addAssignmentBtn: Button
    private lateinit var currentDate: TextView
   // TODO private lateinit var asgnRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assignment = Assignment()
    }

    companion object {
        fun newInstance(): AssignmentListFragment{
            return AssignmentListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_assignments_list, container, false)

        assignmentTitle = view.findViewById(R.id.assignmentTitle) as EditText
        checkBox = view.findViewById(R.id.checkBox) as CheckBox
        dueDateText = view.findViewById(R.id.dueDateTxt) as TextView
        editDate = view.findViewById(R.id.editDate) as EditText
        subjectText = view.findViewById(R.id.subjectTxt) as EditText
        shareBtn = view.findViewById(R.id.shareBtn) as Button
        assignmentsTab = view.findViewById(R.id.assignmentsTab) as TextView
        addAssignmentBtn = view.findViewById(R.id.addAssignmentBtn) as Button
        currentDate = view.findViewById(R.id.currentDate) as TextView

        shareBtn.setOnClickListener{
            //TODO: send assignment details to another user
        }

        addAssignmentBtn.setOnClickListener {
            //TODO: add a new assignment
        }

        currentDate.text = Date().toString()

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                assignment.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {}
        }
        assignmentTitle.addTextChangedListener(titleWatcher)

        val subjectWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                assignment.subject = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {}
        }
        subjectText.addTextChangedListener(subjectWatcher)

        val editDateWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                assignment.dueDate = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {}
        }
        editDate.addTextChangedListener(editDateWatcher)

        //TODO: This crashes the app when trying to check the box
        checkBox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                assignment.isCompleted = isChecked
            }
        }
    }

    private fun updateUI() {
        checkBox.isChecked = assignment.isCompleted
    }
}