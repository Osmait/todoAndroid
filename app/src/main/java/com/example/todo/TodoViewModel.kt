package com.example.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
//    val todoModel = MutableLiveData<MutableList<String>>(TodoProvider.todos)

    fun getTodos() = TodoProvider.todos


    fun delete(position: Int) {
        TodoProvider.todos.removeAt(position)
    }

    fun add(position: Int, item: String) {
        TodoProvider.todos.add(position, item)
    }

}