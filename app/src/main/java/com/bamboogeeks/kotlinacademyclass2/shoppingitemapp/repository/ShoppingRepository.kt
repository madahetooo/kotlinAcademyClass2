package com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.repository

import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.db.ShoppingDatabase
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.model.ShoppingItem

class ShoppingRepository(private val db:ShoppingDatabase) {

    fun upsert(item:ShoppingItem) = db.getShoppingDao().insert(item)

    fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItem()

}