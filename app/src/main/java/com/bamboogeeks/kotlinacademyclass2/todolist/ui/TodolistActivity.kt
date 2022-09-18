package com.bamboogeeks.kotlinacademyclass2.todolist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityTodolistBinding
import com.bamboogeeks.kotlinacademyclass2.todolist.model.Todo
import com.bamboogeeks.kotlinacademyclass2.todolist.utils.TodoAdapter

class TodolistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodolistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodolistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var todolist = mutableListOf(
            Todo("Go To Gym", false),
        )

        val adapter = TodoAdapter(todolist)
        binding.rvTodo.adapter = adapter
        binding.rvTodo.layoutManager = LinearLayoutManager(this)
        binding.btnAddTodo.setOnClickListener {
            val newTodoTitle = binding.etTodo.text.toString()
            if (newTodoTitle.isNotEmpty()){
                val newTodo = Todo(newTodoTitle,false)
                todolist.add(newTodo)
                adapter.notifyDataSetChanged()
                binding.etTodo.text.clear()
            }
        }
    }
}