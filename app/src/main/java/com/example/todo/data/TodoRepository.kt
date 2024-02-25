package com.example.todo.data

import androidx.lifecycle.LiveData
import com.example.todo.data.db.TodoDao
import com.example.todo.data.db.TodoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    private val allTodo: LiveData<List<TodoEntity>> = todoDao.getAllTodoList()

    fun saveTodo(todo: TodoEntity) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoDao.saveTodo(todo)
        }
    }

    fun updateTodo(todo: TodoEntity) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoDao.updateTodo(todo)
        }
    }

    fun deleteTodo(todo: TodoEntity) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                todoDao.deleteTodo(todo)
            }
        }
    }

    fun getAllTodoList(): LiveData<List<TodoEntity>> {
        return allTodo
    }
}