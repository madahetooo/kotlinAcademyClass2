package com.bamboogeeks.kotlinacademyclass2

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityRestaurantBinding

class RestaurantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOrder.setOnClickListener {
            val checkedMealRadioButtonId = binding.rgMeals.checkedRadioButtonId
            val burger = findViewById<RadioButton>(checkedMealRadioButtonId)
            val cheese = binding.cbCheese.isChecked
            val onionsRings = binding.cbOnionsRings.isChecked
            val salad = binding.cbSalad.isChecked

            val totalOrder = "You Order a burger with \n"+
                    "${burger.text}" +
                    (if(cheese) "\nCheese " else "")+
                    (if(onionsRings) "\nOnionsRings " else "")+
                    (if(salad) "\nSalad " else "")

            binding.txTotalOrder.text = totalOrder
        }
    }
}