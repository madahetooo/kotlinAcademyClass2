package com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.bamboogeeks.kotlinacademyclass2.databinding.ItemAddShoppingDialogBinding
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.model.ShoppingItem

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :AppCompatDialog(context){

    private lateinit var binding: ItemAddShoppingDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemAddShoppingDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShoppingDialogCancel.setOnClickListener {
            cancel()
        }

        binding.btnShoppingDialogAdd.setOnClickListener {
         var shoppingItemName =    binding.etShoppingItemDialogName.text.toString()
         var shoppingItemAmount =    binding.etShoppingItemDialogAmount.text.toString()
            if (shoppingItemName.isEmpty() ||shoppingItemAmount.isEmpty() ){
                Toast.makeText(context,"Please enter item name or amount",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
          var item =   ShoppingItem(shoppingItemName,shoppingItemAmount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
    }
}