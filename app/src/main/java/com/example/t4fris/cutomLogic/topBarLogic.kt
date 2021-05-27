package com.example.t4fris.cutomLogic

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.top_bar.view.*

class topBarLogic (view: View) {

    val cartButton: ImageView = view.cart
    val searchButton: ImageView = view.search
    val backButton: ImageView = view.backArrow

    val headerTextView: TextView = view.topBarText



}