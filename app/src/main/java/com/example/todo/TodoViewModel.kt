package com.example.todo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo.data.TodoRepository
import com.example.todo.data.db.TodoEntity

class TodoViewModel(private val todoRepository: TodoRepository) :
    ViewModel() {
    //    val todoModel = MutableLiveData<MutableList<String>>(TodoProvider.todos)

    fun getTodos() = todoRepository.getAllTodoList()


    fun delete(todoEntity: TodoEntity) {
        todoRepository.deleteTodo(todoEntity)
    }

    fun add(todoEntity: TodoEntity) {
        todoRepository.saveTodo(todoEntity)
    }

}