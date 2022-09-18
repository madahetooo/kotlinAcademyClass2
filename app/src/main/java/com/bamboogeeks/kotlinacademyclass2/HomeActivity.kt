package com.bamboogeeks.kotlinacademyclass2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bamboogeeks.kotlinacademyclass2.calculatorapp.CalculatorActivity
import com.bamboogeeks.kotlinacademyclass2.counterapp.CounterActivity
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityHomeBinding
import com.bamboogeeks.kotlinacademyclass2.restaurantapp.RestaurantActivity
import com.bamboogeeks.kotlinacademyclass2.todolist.ui.TodolistActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculatorApp.setOnClickListener {
            var intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
        binding.btnCounterApp.setOnClickListener {
            var intent = Intent(this, CounterActivity::class.java)
            startActivity(intent)
        }
        binding.btnRestaurantApp.setOnClickListener {
            var intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }
        binding.btnTodoListApp.setOnClickListener {
            var intent = Intent(this,TodolistActivity::class.java)
            startActivity(intent)
        }
    }
}