package com.example.cs4518_finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat
import android.widget.CalendarView.OnDateChangeListener
import java.util.*

private const val TAG = "CalendarFragment"

class CalendarFragment : Fragment(){

    private lateinit var calendarRecyclerView: RecyclerView
    private lateinit var dueOnTxt: TextView
    private lateinit var selectedDate: TextView
    private lateinit var calendar: CalendarView
    private var adapter: CalendarAdapter? = CalendarAdapter(emptyList())

    private val calendarViewModel: CalendarViewModel by lazy {
        ViewModelProviders.of(this).get(CalendarViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)

        calendarRecyclerView =
            view.findViewById(R.id.calendarRecyclerView) as RecyclerView
        calendarRecyclerView.layoutManager = LinearLayoutManager(context)
        calendarRecyclerView.adapter = adapter

        dueOnTxt = view.findViewById(R.id.dueOnTxt) as TextView
        selectedDate = view.findViewById(R.id.selectedDate) as TextView
        calendar = view.findViewById(R.id.calendarView) as CalendarView

        val cal = Calendar.getInstance()

        calendar.setOnDateChangeListener { calendar, year, month, dayOfMonth ->
            cal.set(year,month,dayOfMonth)
            calendar.date = cal.timeInMillis

            val dateSelected: Long = calendar.date
            cal.timeInMillis = dateSelected
            val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
            selectedDate.text = dateFormatter.format(cal.time)
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var assignmentList = calendarViewModel.getAssignmentsFromDate(selectedDate.toString())
        assignmentList.observe(
            viewLifecycleOwner,
            {
                assignmentList.value?.let {
                        it1 -> updateUI(it1)
                }
            }
        )
    }

    override fun onStart() {
        super.onStart()
    }

    private fun updateUI(asgns: List<Assignment>){
        adapter = CalendarAdapter(asgns)
        calendarRecyclerView.adapter = adapter
    }

    private inner class CalendarHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        private lateinit var asgn: Assignment

        private val title: TextView = itemView.findViewById(R.id.assignmentTitle)
        private val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        private val date: TextView = itemView.findViewById(R.id.date)
        private val subject: TextView = itemView.findViewById(R.id.subjectTxt)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(asgn: Assignment){
            this.asgn = asgn
            title.text = this.asgn.title
            checkBox.isChecked = this.asgn.isCompleted
            date.text = this.asgn.dueDate
            subject.text = this.asgn.subject
        }

        override fun onClick(v: View?) {
        }
    }

    private inner class CalendarAdapter(var asgns: List<Assignment>): RecyclerView.Adapter<CalendarHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarHolder {
            val view = layoutInflater.inflate(R.layout.list_item_assignment, parent, false)
            return CalendarHolder(view)
        }

        override fun getItemCount() = asgns.size

        override fun onBindViewHolder(holder: CalendarHolder, position: Int) {
            val asgn = asgns[position]
            holder.bind(asgn)
        }
    }
}