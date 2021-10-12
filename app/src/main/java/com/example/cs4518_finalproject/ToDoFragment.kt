package com.example.cs4518_finalproject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

private const val TAG = "ToDoFragment"

class ToDoFragment : Fragment(){

    private lateinit var toDoRecyclerView: RecyclerView
    private lateinit var toDo: ToDo
    private lateinit var toDoTitle: EditText
    private lateinit var checkBox: CheckBox
    private var adapter: ToDoAdapter? = ToDoAdapter(emptyList())

    private val toDoViewModel: ToDoViewModel by lazy {
        ViewModelProviders.of(this).get(ToDoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total toDos") //TODO: need to link database for toDos.size (pg. 354)
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

        toDoTitle = view.findViewById(R.id.toDoTitle) as EditText
        checkBox = view.findViewById(R.id.toDoComplete) as CheckBox

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO liveData, obeserver, updateUI
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
                toDo.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {}
        }

        toDoTitle.addTextChangedListener(titleWatcher)
    }

    private fun updateUI(toDos: List<ToDo>){
        adapter = ToDoAdapter(toDos)
        toDoRecyclerView.adapter = adapter
    }

    private inner class ToDoHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var toDo: ToDo

        private val toDoTitlePrivate: EditText = itemView.findViewById(R.id.toDoTitle)
        private val checkBox: CheckBox = itemView.findViewById(R.id.toDoComplete)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(toDo: ToDo){
            this.toDo = toDo //TODO: pretty sure more needs to go here, having trouble with EditText
        }

        override fun onClick(v: View?) {
            //TODO: implement this if needed, not clicking for detailed view so maybe we dont?
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