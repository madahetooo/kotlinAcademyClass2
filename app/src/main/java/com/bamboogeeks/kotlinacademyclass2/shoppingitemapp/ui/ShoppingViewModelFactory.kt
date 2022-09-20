package com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.repository.ShoppingRepository

class ShoppingViewModelFactory(private val repository: ShoppingRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}