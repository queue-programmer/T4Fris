package com.example.t4fris.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.t4fris.Database.CartObject
import com.example.t4fris.Repository.CartRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel: ViewModel() {

    private val cartRepo = CartRepo()
    val cartLiveData = MutableLiveData<List<CartObject>>()

    val totalPriceLiveData = MutableLiveData<Int>()

    fun getCart(){
        CoroutineScope(Dispatchers.IO).launch{

            val cart =cartRepo.getCart()
            if (cartLiveData.value != cart){
                cartLiveData.postValue(cart)
            }

            var price = 0
            for (cartObject in cart){
                price += (cartObject.itemPrice * cartObject.amount)
            }

            getTotalPrice(price)
        }
    }

    fun getTotalPrice(totalPrice: Int){
        if (totalPriceLiveData.value != totalPrice){
            totalPriceLiveData.postValue(totalPrice)
        }
    }
}