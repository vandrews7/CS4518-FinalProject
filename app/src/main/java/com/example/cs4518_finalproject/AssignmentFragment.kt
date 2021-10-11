package com.example.cs4518_finalproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import java.util.*

private const val TAG = "AssignmentFragment"
private const val REQUEST_CODE = 0
private const val ARG_ASSIGN_ID = "assignment_id"

class GameFragment: Fragment(){

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assignment = Assignment()
        val assignmentID: UUID = arguments?.getSerializable(ARG_ASSIGN_ID) as UUID
        Log.d(TAG, "arg bundle assignment ID: $assignmentID")
        //TODO: make assignmentDetailViewModel
        //assignmentDetailViewModel.loadAssignment(assignmentID)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_assignments, container, false)

        assignmentTitle = view.findViewById(R.id.assignmentTitle) as EditText
        checkBox = view.findViewById(R.id.checkBox) as CheckBox
        dueDateText = view.findViewById(R.id.dueDateTxt) as TextView
        editDate = view.findViewById(R.id.editDate) as EditText
        subjectText = view.findViewById(R.id.subjectTxt) as EditText
        shareBtn = view.findViewById(R.id.shareBtn) as Button
        assignmentsTab = view.findViewById(R.id.assignmentsTab) as TextView

        return view
    }


}