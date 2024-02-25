package com.example.todo.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {
    @Insert
    suspend fun saveTodo(todoEntity: TodoEntity)

    @Delete
    suspend fun deleteTodo(todoEntity: TodoEntity)

    @Update
    suspend fun updateTodo(todoEntity: TodoEntity)

    @Query("SELECT * FROM todo ORDER BY id DESC")
    fun getAllTodoList(): LiveData<List<TodoEntity>>
}