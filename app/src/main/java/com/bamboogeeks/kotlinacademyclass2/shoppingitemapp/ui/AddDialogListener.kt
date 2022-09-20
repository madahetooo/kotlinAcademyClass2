package com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.ui

import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.model.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}