package com.example.t4fris.Repository

import com.example.t4fris.Database.AppDatabase
import com.example.t4fris.Database.CartObject
import com.example.t4fris.FrisApp

class CartRepo {

    val cartDao = AppDatabase.getDatabase(FrisApp.application.applicationContext).cartDAO()

    fun getCart(): List<CartObject>{

        return cartDao.getCart()
    }

    fun getItemFromCart(name: String): CartObject?{

        return cartDao.getItemFromCart(name)
    }

    fun addToCart(itemName:String, itemPrice: Int){

        var amount = 1

        if(getItemFromCart(itemName) != null){
            amount = getItemFromCart(itemName)?.amount!! + 1
        }
        val objectToPutInCart = CartObject(itemName, itemPrice, amount)

        cartDao.insertToCart(objectToPutInCart)
    }
}