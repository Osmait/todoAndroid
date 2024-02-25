package com.example.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter (private  var todoList:List<String> = emptyList(),private val onClickDelete:((Int) -> Unit)):RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
      return  TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false))
    }

    override fun getItemCount(): Int {
       return  todoList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
     holder.render(todoList[position],onClickDelete)
    }

}