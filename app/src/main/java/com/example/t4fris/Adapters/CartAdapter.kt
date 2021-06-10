package com.example.t4fris.Adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t4fris.Database.CartObject
import com.example.t4fris.cutomLogic.CartViewLogic

class CartAdapter(private var dataset: List<CartObject>): RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val listItem = CartViewLogic(parent.context)

        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartObject = dataset[position]

        holder.listItem.setItem(cartObject)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun update(newList: List<CartObject>){
        dataset = newList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val listItem: CartViewLogic): RecyclerView.ViewHolder(listItem)
}