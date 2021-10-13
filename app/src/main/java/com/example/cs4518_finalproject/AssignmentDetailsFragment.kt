package com.example.cs4518_finalproject

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import java.text.SimpleDateFormat
import java.time.Month
import java.util.*

private const val DIALOG_DATE = "DialogDate"

class AssignmentDetailsFragment : Fragment(){

    private val asgnDetailsViewModel: AssignmentDetailsViewModel by lazy {
        ViewModelProviders.of(this).get(AssignmentDetailsViewModel::class.java)
    }

    private lateinit var asgn: Assignment
    private lateinit var asgnTitle: EditText
    private lateinit var dueDateBtn: Button
    private lateinit var dueDate: TextView
    private lateinit var subjectTxt: TextView
    private lateinit var subject: EditText
    private lateinit var notes: EditText
    private lateinit var sharedWithTxt: TextView
    private lateinit var collabEmail: TextView
    private lateinit var detailsTxt: TextView
    private lateinit var checkBox: CheckBox
    private lateinit var createAssignment: Button

    private var cal = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_assignment_details, container, false)
        asgn = Assignment()

        asgnTitle = view.findViewById(R.id.assignmentTitleTxt) as EditText
        dueDateBtn = view.findViewById(R.id.chooseDueDate) as Button
        dueDate = view.findViewById(R.id.detailsDueDate) as TextView
        subjectTxt = view.findViewById(R.id.detailsSubjectTxt) as TextView
        subject = view.findViewById(R.id.detailsSubject) as EditText
        notes = view.findViewById(R.id.detailsNotes) as EditText
        sharedWithTxt = view.findViewById(R.id.sharedWith) as TextView
        collabEmail = view.findViewById(R.id.collaboratorEmail) as TextView
        detailsTxt = view.findViewById(R.id.detailsTxt) as TextView
        checkBox = view.findViewById(R.id.detailsCheckBox) as CheckBox
        createAssignment = view.findViewById(R.id.createAssignment) as Button
        asgn = Assignment()

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


        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, day)
                updateDateInView()
            }

        }

        dueDateBtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                DatePickerDialog(requireActivity(),
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        return view
    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        dueDate!!.text = sdf.format(cal.getTime())
        asgn.dueDate = sdf.format(cal.getTime()).toString()
    }

    override fun onStart() {
        super.onStart()
    }
}