package com.example.todo

import androidx.lifecycle.ViewModel
import com.example.todo.data.TodoRepository
import com.example.todo.data.db.TodoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel
@Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {
    //    val todoModel = MutableLiveData<MutableList<String>>(TodoProvider.todos)

    fun getTodos() = todoRepository.getAllTodoList()


    fun delete(todoEntity: TodoEntity) {
        todoRepository.deleteTodo(todoEntity)
    }

    fun add(todoEntity: TodoEntity) {
        todoRepository.saveTodo(todoEntity)
    }

}