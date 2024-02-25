package com.example.todo.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo")
class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo("title") val title: String,
    @ColumnInfo(name = "content") val content: String,
)