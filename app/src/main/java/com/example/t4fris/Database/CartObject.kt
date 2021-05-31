package com.example.t4fris.Database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cart_table")
data class CartObject (
    @PrimaryKey
    val itemName: String,
    val itemPrice: Int,
    var amount: Int
        )
