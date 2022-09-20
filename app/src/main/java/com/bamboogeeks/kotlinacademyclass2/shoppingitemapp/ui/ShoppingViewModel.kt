package com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.ui

import androidx.lifecycle.ViewModel
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.model.ShoppingItem
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel() {

    fun upsert(item:ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }
    fun getAllShoppingItems() = repository.getAllShoppingItem()
}