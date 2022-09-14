package com.bamboogeeks.kotlinacademyclass2.todolist.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bamboogeeks.kotlinacademyclass2.databinding.ItemTodoBinding
import com.bamboogeeks.kotlinacademyclass2.todolist.model.Todo

class TodoAdapter(var todos :List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
     holder.binding.tvTodoTitle.text = todos[position].title
     holder.binding.cbDone.isChecked = todos[position].isChecked
    }

    override fun getItemCount(): Int {
        return  todos.size
    }
}