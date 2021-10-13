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
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

class AssignmentDetailsFragment : Fragment(){

    private val asgnDetailsViewModel: AssignmentDetailsViewModel by lazy {
        ViewModelProviders.of(this).get(AssignmentDetailsViewModel::class.java)
    }

    private lateinit var asgn: Assignment
    private lateinit var asgnTitle: EditText
    private lateinit var dueDateTxt: TextView
    private lateinit var dueDate: EditText
    private lateinit var subjectTxt: TextView
    private lateinit var subject: EditText
    private lateinit var notes: EditText
    private lateinit var sharedWithTxt: TextView
    private lateinit var collabEmail: TextView
    private lateinit var detailsTxt: TextView
    private lateinit var checkBox: CheckBox
    private lateinit var createAssignment: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_assignment_details, container, false)
        asgn = Assignment()

        asgnTitle = view.findViewById(R.id.assignmentTitleTxt) as EditText
        dueDateTxt = view.findViewById(R.id.detailsDueDateTxt) as TextView
        dueDate = view.findViewById(R.id.detailsDueDate) as EditText
        subjectTxt = view.findViewById(R.id.detailsSubjectTxt) as TextView
        subject = view.findViewById(R.id.detailsSubject) as EditText
        notes = view.findViewById(R.id.detailsNotes) as EditText
        sharedWithTxt = view.findViewById(R.id.sharedWith) as TextView
        collabEmail = view.findViewById(R.id.collaboratorEmail) as TextView //TODO implement so it displays collaborator's emails
        detailsTxt = view.findViewById(R.id.detailsTxt) as TextView
        checkBox = view.findViewById(R.id.detailsCheckBox) as CheckBox //TODO make this work
        createAssignment = view.findViewById(R.id.createAssignment) as Button

        fun makeNewAssignment(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, AssignmentListFragment())
            transaction.addToBackStack(null)
            transaction.commit()
            asgnDetailsViewModel.addAssignment(asgn) //this adds the assignment to the database
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
            ) { asgn.title = sequence.toString() }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        asgnTitle.addTextChangedListener(titleWatcher)

        val dueDateWatcher = object : TextWatcher { //TODO change to dialog
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
            ) { asgn.dueDate = sequence.toString() }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        dueDate.addTextChangedListener(dueDateWatcher)

        val subjectWatcher = object : TextWatcher {
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
            ) { asgn.subject = sequence.toString() }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        subject.addTextChangedListener(subjectWatcher)

        val notesWatcher = object : TextWatcher {
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
            ) { }

            override fun afterTextChanged(sequence: Editable?) { }
        }
        notes.addTextChangedListener(notesWatcher)

        createAssignment.setOnClickListener{
            makeNewAssignment()
        }


        return view
    }
}