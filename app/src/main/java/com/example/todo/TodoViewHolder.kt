package com.example.todo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.data.db.TodoEntity
import com.example.todo.databinding.ItemTodoBinding

class TodoViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private  val binding = ItemTodoBinding.bind(view)
    fun render(todo: TodoEntity, onClickDelete: (TodoEntity,Int) -> Unit){
        binding.todoTitle.text =todo.title
        binding.btnDelete.setOnClickListener { onClickDelete(todo,adapterPosition) }
    }
}