package com.example.myandroidapp.utils

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroidapp.databinding.EachTodoItemBinding
import com.example.myandroidapp.utils.ToDoData
//import com.example.myandroidapp.utils.model.ToDoData

class ToDoAdapter(private val list: MutableList<ToDoData>)
    : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    private var listener:ToDoAdapterClicksInterface?=null
    fun setListener(listener:ToDoAdapterClicksInterface)
    {
        this.listener=listener
    }
    inner class ToDoViewHolder(val binding:EachTodoItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = EachTodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.todoTask.text = this.task


                binding.editTask.setOnClickListener {
                    listener?.onEditTaskBtnClicked(this)
                }

                binding.deleteTask.setOnClickListener {
                    listener?.onDeleteTaskBtnClicked(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ToDoAdapterClicksInterface{
        fun onDeleteTaskBtnClicked(toDoData: ToDoData)
        fun onEditTaskBtnClicked(toDoData: ToDoData)
    }

}