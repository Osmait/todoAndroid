package com.example.todo


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val todoViewModel: TodoViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        setListener()

    }

    private fun initUI() {
        todoAdapter = TodoAdapter(todoViewModel.getTodos()) { position -> deleteTodo(position) }

        binding.apply {
            rvTodo.apply {
                adapter = todoAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

        }


    }

    private fun setListener() {
        binding.btnStart.setOnClickListener {
            val todo = binding.nameInput.text.toString()
            if (todo.isEmpty()) return@setOnClickListener
            todoViewModel.add(0, todo)
            binding.nameInput.text?.clear()
            todoAdapter.notifyItemInserted(0)
        }
    }

    private fun deleteTodo(position: Int) {
        todoViewModel.delete(position)
        todoAdapter.notifyItemRemoved(position)

    }
}