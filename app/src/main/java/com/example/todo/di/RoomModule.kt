package com.example.todo.di

import android.content.Context
import androidx.room.Room
import com.example.todo.data.db.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Singleton
    @Provides
    fun providesRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TodoDatabase::class.java, "todo_db").build()

    @Singleton
    @Provides
    fun providesTodoDao(db: TodoDatabase) = db.todoDao()

}