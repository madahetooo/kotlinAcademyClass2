package com.bamboogeeks.kotlinacademyclass2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCounterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 0
        binding.btnCounter.setOnClickListener {
            count++
            binding.txCounter.text = "Lets Count Together $count"
        }
    }
}