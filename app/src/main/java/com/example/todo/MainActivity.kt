package com.example.todo


import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.data.db.TodoEntity
import com.example.todo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        /*    val db: TodoDatabase? = TodoDatabase.getInstance(this)
            val repository = TodoRepository(db!!)
            val viewModelProviderFactory = TodoViewModelFactory(repository)
            todoViewModel = ViewModelProvider(this, viewModelProviderFactory)[TodoViewModel::class.java]*/
        todoAdapter = TodoAdapter(emptyList()) { todo, position -> deleteTodo(todo, position) }
        todoViewModel.getTodos().observe(this, Observer {
            todoAdapter.todoList = it
            Log.d("osmait", it.toString())
            todoAdapter.notifyDataSetChanged()
        })

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
            val todoSave = TodoEntity(null, title = todo, content = "Description")
            todoViewModel.add(todoSave)
            binding.nameInput.text?.clear()

        }
    }

    private fun deleteTodo(todoEntity: TodoEntity, position: Int) {
        todoViewModel.delete(todoEntity)


    }
}