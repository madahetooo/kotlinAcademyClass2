package com.bamboogeeks.kotlinacademyclass2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txLogin.setOnClickListener {
            // Navigating from Login Activity to Registration Activity
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnRegister.setOnClickListener {
            var intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}