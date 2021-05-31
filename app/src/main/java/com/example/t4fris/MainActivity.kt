package com.example.t4fris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.t4fris.Repository.CartRepo
import com.example.t4fris.cutomLogic.topBarLogic
import com.example.t4fris.fragments.FriscardFragment
import com.example.t4fris.fragments.HomeFragment
import com.example.t4fris.fragments.MapFragment
import com.example.t4fris.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var topBar: topBarLogic

    lateinit var cartRepo: CartRepo

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.itemIconTintList = null
        val navController = findNavController(R.id.navHostFrag)
        navView.setupWithNavController(navController)


        supportActionBar?.hide()

        topBar = topBarLogic(findViewById(R.id.conTop_bar))

        topTextChange("utforsk")

        setOnClickListeners()

        cartRepo = CartRepo()
    }

    fun setOnClickListeners(){

        topBar.cartButton.setOnClickListener{
            cartButtonLogic()
        }
        topBar.searchButton.setOnClickListener{
            searchButtonLogic()
        }
        topBar.backButton.setOnClickListener{
            onBackPressed()
        }




    }

    fun cartButtonLogic(){
//        Toast.makeText(this, "Pressed the cart button!", Toast.LENGTH_SHORT).show()

        printCart()
    }

    fun searchButtonLogic(){
        Toast.makeText(this, "Pressed the search button!", Toast.LENGTH_SHORT).show()
    }

    fun topTextChange(title: String ){
        topBar.headerTextView.text = title
    }

    fun printCart(){

        CoroutineScope(Dispatchers.IO).launch {
            Log.d("Debug", cartRepo.getCart().toString())
        }
    }
}