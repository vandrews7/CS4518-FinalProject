package com.example.cs4518_finalproject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

private const val TAG = "ToDoFragment"

class ToDoFragment : Fragment(){

    private lateinit var toDoRecyclerView: RecyclerView
    private lateinit var toDoTxt: TextView
    private lateinit var addToDoBtn: Button
    private lateinit var home: Button
    private var adapter: ToDoAdapter? = ToDoAdapter(emptyList())

    private val toDoViewModel: ToDoViewModel by lazy {
        ViewModelProviders.of(this).get(ToDoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "ToDo onCreate() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_to_do, container, false)
        toDoRecyclerView =
            view.findViewById(R.id.toDoRecyclerView) as RecyclerView
        toDoRecyclerView.layoutManager = LinearLayoutManager(context)
        toDoRecyclerView.adapter = adapter

        toDoTxt = view.findViewById(R.id.toDoTxt) as TextView
        addToDoBtn = view.findViewById(R.id.addToDoBtn) as Button
        home = view.findViewById(R.id.returnHome) as Button

        fun loadToDoDetails(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, ToDoDetailsFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun loadHome(){
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        addToDoBtn.setOnClickListener{loadToDoDetails()}
        home.setOnClickListener{loadHome()}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var toDoList = toDoViewModel.todoListLiveData
        toDoList.observe(
            viewLifecycleOwner,
            {
                toDoList.value?.let {
                        it1 -> updateUI(it1)
                }
            }
        )
    }

    override fun onStart() {
        super.onStart()
    }

    private fun updateUI(toDos: List<ToDo>){
        adapter = ToDoAdapter(toDos)
        toDoRecyclerView.adapter = adapter
    }

    private inner class ToDoHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var toDo: ToDo

        private val title: TextView = itemView.findViewById(R.id.toDoTitle)
        private val checkBox: CheckBox = itemView.findViewById(R.id.toDoComplete)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(toDo: ToDo){
            this.toDo = toDo
            title.text = this.toDo.title
            checkBox.isChecked = this.toDo.isCompleted
        }

        override fun onClick(v: View?) {

        }

    }

    private inner class ToDoAdapter(var toDos: List<ToDo>): RecyclerView.Adapter<ToDoHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
            val view = layoutInflater.inflate(R.layout.list_item_todo, parent,false)
            return ToDoHolder(view)
        }

        override fun getItemCount() = toDos.size

        override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
            val toDo = toDos[position]
            holder.bind(toDo)
        }
    }

}