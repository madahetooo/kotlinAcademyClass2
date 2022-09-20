package com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bamboogeeks.kotlinacademyclass2.databinding.ItemShoppingBinding
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.model.ShoppingItem
import com.bamboogeeks.kotlinacademyclass2.shoppingitemapp.ui.ShoppingViewModel

class ShoppingItemAdapter(var items: List<ShoppingItem>,private val viewModel: ShoppingViewModel) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    inner class ShoppingViewHolder(val binding: ItemShoppingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(ItemShoppingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
      var currentShoppingItem =  items[position]
      holder.binding.txShoppingItemName.text =  currentShoppingItem.name
      holder.binding.txShoppingItemAmount.text =  "${currentShoppingItem.amount}"
        holder.binding.ivShoppingItemDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
        holder.binding.ivShoppingItemAdd.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }
        holder.binding.ivShoppingItemMinus.setOnClickListener {
            if (currentShoppingItem.amount > 0){
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}