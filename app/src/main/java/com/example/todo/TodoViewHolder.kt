package com.example.todo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ItemTodoBinding

class TodoViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private  val binding = ItemTodoBinding.bind(view)
    fun render(todo: String, onClickDelete: (Int) -> Unit){
        binding.todoTitle.text =todo
        binding.btnDelete.setOnClickListener { onClickDelete(adapterPosition) }
    }
}