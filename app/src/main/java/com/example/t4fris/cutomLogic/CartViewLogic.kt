package com.example.t4fris.cutomLogic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.t4fris.Database.CartObject
import com.example.t4fris.R

class CartViewLogic(context: Context): CardView(context) {

    val name: TextView
    val quantity: TextView
    val price: TextView

    val view: View = LayoutInflater.from(context).inflate(R.layout.custom_cart_view, this)

    init {
        name = view.findViewById(R.id.product)
        quantity = view.findViewById(R.id.productQuantity)
        price = view.findViewById(R.id.productPrice)
    }

    fun setItem(cartObject: CartObject){

        name.text = cartObject.itemName
        price.text = "Price: ${cartObject.itemPrice.toString()}"
        quantity.text = "Amount: ${cartObject.amount.toString()}"
    }
}