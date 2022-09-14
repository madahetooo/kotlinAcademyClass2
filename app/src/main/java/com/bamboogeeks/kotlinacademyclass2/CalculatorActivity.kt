package com.bamboogeeks.kotlinacademyclass2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddition.setOnClickListener {
            val firstNumber =
                binding.etFirstNumber.text.toString().toInt() // Getting The Value of FirstNumber
            val secondNumber =
                binding.etSecondNumber.text.toString().toInt() // Getting The Value of FirstNumber
            val result = firstNumber + secondNumber // Making the Addition Operation
            binding.txResult.text = result.toString() // Setting the result on the Text View
        }

        binding.btnMinus.setOnClickListener {
            val firstNumber =
                binding.etFirstNumber.text.toString().toInt() // Getting The Value of FirstNumber
            val secondNumber =
                binding.etSecondNumber.text.toString().toInt() // Getting The Value of FirstNumber
            val result = firstNumber - secondNumber // Making the Addition Operation
            binding.txResult.text = result.toString() // Setting the result on the Text View
        }
        binding.btnMultiply.setOnClickListener {
            val firstNumber =
                binding.etFirstNumber.text.toString().toInt() // Getting The Value of FirstNumber
            val secondNumber =
                binding.etSecondNumber.text.toString().toInt() // Getting The Value of FirstNumber
            val result = firstNumber * secondNumber // Making the Addition Operation
            binding.txResult.text = result.toString() // Setting the result on the Text View
        }

        binding.btnDivision.setOnClickListener {
            val firstNumber =
                binding.etFirstNumber.text.toString().toInt() // Getting The Value of FirstNumber
            val secondNumber =
                binding.etSecondNumber.text.toString().toInt() // Getting The Value of FirstNumber
            val result = firstNumber / secondNumber // Making the Addition Operation
            binding.txResult.text = result.toString() // Setting the result on the Text View
        }
        binding.btnClear.setOnClickListener {
            binding.etFirstNumber.text.clear()
            binding.etSecondNumber.text.clear()
            binding.txResult.text = ""
        }
    }
}