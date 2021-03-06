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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.util.*

private const val TAG = "AssignmentListFragment"

class AssignmentListFragment: Fragment(){

    private lateinit var asgnRecyclerView: RecyclerView
    private lateinit var asgn: Assignment
    private lateinit var assignmentTxt: TextView
    private lateinit var addAsgnBtn: Button
    private lateinit var date: TextView
    private lateinit var home: Button
    private var adapter: AssignmentAdapter? = AssignmentAdapter(emptyList())

    private val assignmentListViewModel: AssignmentListViewModel by lazy {
       ViewModelProviders.of(this).get(AssignmentListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total assignments")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_assignments_list, container,false)
        asgnRecyclerView =
            view.findViewById(R.id.assignmentsRecyclerView) as RecyclerView
        asgnRecyclerView.layoutManager = LinearLayoutManager(context)
        asgnRecyclerView.adapter = adapter

        assignmentTxt = view.findViewById(R.id.assignmentsTab) as TextView
        addAsgnBtn = view.findViewById(R.id.addAssignmentBtn) as Button
        date = view.findViewById(R.id.currentDate) as TextView
        home = view.findViewById(R.id.asgnReturnHome) as Button
        asgn = Assignment()

        date.text = Date().toString()

        fun loadAsgnDetails(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, AssignmentDetailsFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun loadHome(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        addAsgnBtn.setOnClickListener{ loadAsgnDetails()}
        home.setOnClickListener{loadHome()}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var assignmentList = assignmentListViewModel.assignmentListLiveData
        assignmentList.observe(
            viewLifecycleOwner,
            {
                assignmentList.value?.let {
                        it1 -> updateUI(it1)
                }
            }
        )
    }

    private fun updateUI(asgns: List<Assignment>){
        adapter = AssignmentAdapter(asgns)
        asgnRecyclerView.adapter = adapter
    }

    private inner class AssignmentHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{
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

    private inner class AssignmentAdapter(var asgns: List<Assignment>): RecyclerView.Adapter<AssignmentHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentHolder {
            val view = layoutInflater.inflate(R.layout.list_item_assignment, parent, false)
            return AssignmentHolder(view)
        }

        override fun getItemCount() = asgns.size

        override fun onBindViewHolder(holder: AssignmentHolder, position: Int) {
            val asgn = asgns[position]
            holder.bind(asgn)
        }

    }

}