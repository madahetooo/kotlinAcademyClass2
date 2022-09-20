package com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bamboogeeks.kotlinacademyclass2.databinding.ActivityShoppingBinding
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.db.ShoppingDatabase
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.model.ShoppingItem
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.repository.ShoppingRepository
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.ui.utils.ShoppingItemAdapter

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        val shoppingItemAdapter = ShoppingItemAdapter(listOf(), viewModel)
        binding.rvShoppingItems.adapter = shoppingItemAdapter
        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)

        viewModel.getAllShoppingItems().observe(this, Observer { shoppingItemsList ->
            shoppingItemAdapter.items = shoppingItemsList
            shoppingItemAdapter.notifyDataSetChanged()
        })

        binding.fabAddShoppingItem.setOnClickListener {
            AddShoppingItemDialog(this,object :AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}