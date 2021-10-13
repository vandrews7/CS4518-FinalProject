package com.example.cs4518_finalproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "SharedFragment"

class SharedFragment : Fragment(){

    private lateinit var sharedRecyclerView: RecyclerView
    private lateinit var shared: SharedAssignment

    private var adapter: SharedAdapter? = SharedAdapter(emptyList())

    private val sharedViewModel: SharedViewModel by lazy {
        ViewModelProviders.of(this).get(SharedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total shared assignments")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shared, container,false)
        sharedRecyclerView =
            view.findViewById(R.id.sharedRecyclerView) as RecyclerView
        sharedRecyclerView.layoutManager = LinearLayoutManager(context)
        sharedRecyclerView.adapter = adapter

        return view
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun updateUI(sharedAsgns: List<SharedAssignment>){
        adapter = SharedAdapter(sharedAsgns)
        sharedRecyclerView.adapter = adapter
    }

    private inner class SharedHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var shared: SharedAssignment

        private val sharedTitle: TextView = itemView.findViewById(R.id.assignmentTitle)


        init {
            itemView.setOnClickListener(this)
        }

        fun bind(shared: SharedAssignment){
            this.shared = shared
        }

        override fun onClick(v: View?) {
        }
    }

    private inner class SharedAdapter(var sharedAsgns: List<SharedAssignment>): RecyclerView.Adapter<SharedHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SharedHolder {
            val view = layoutInflater.inflate(R.layout.list_item_shared, parent,false)
            return SharedHolder(view)
        }

        override fun getItemCount() = sharedAsgns.size

        override fun onBindViewHolder(holder: SharedHolder, position: Int) {
            val shared = sharedAsgns[position]
            holder.bind(shared)
        }
    }


}