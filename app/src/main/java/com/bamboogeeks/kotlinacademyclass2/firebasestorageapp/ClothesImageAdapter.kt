package com.bamboogeeks.kotlinacademyclass2.firebasestorageapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bamboogeeks.kotlinacademyclass2.databinding.ItemClothesBinding
import com.bumptech.glide.Glide

class ClothesImageAdapter(var urls:List<String>) :RecyclerView.Adapter<ClothesImageAdapter.ClothesImageViewHolder>(){
    inner class ClothesImageViewHolder(val binding: ItemClothesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesImageViewHolder {
    return ClothesImageViewHolder(ItemClothesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ClothesImageViewHolder, position: Int) {
    val urls = urls[position]
    Glide.with(holder.itemView).load(urls).into(holder.binding.ivClothesItem)
    }

    override fun getItemCount(): Int {
        return urls.size
    }
}