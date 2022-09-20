package com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.model.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item:ShoppingItem)

    @Delete
    fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>

}