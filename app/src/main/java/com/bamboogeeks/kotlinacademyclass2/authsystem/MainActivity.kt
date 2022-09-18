package com.bamboogeeks.kotlinacademyclass2.authsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bamboogeeks.kotlinacademyclass2.HomeActivity
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txRegister.setOnClickListener {
            // Navigating from Login Activity to Registration Activity
            var intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}