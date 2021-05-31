package com.example.t4fris.Database

import androidx.room.*

@Dao
interface CartDAO {
    @Delete
    fun deleteFromCart(cartToDelete: CartObject)

    @Query ("SELECT * FROM cart_table")
    fun deleteCart()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToCart(cartToInsert: CartObject)

    @Query("SELECT * FROM cart_table")
    fun getCart(): List<CartObject>
}
