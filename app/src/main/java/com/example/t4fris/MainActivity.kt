package com.example.t4fris

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.t4fris.Notifications.Notificatons
import com.example.t4fris.Repository.CartRepo
import com.example.t4fris.cutomLogic.topBarLogic
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_map.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var topBar: topBarLogic

    lateinit var cartRepo: CartRepo

    private lateinit var notificatons: Notificatons

    override fun onCreate(savedInstanceState: Bundle?)  {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.itemIconTintList = null
        val navController = findNavController(R.id.navHostFrag)
        navView.setupWithNavController(navController)

        notificatons = Notificatons(getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
        notificatons.makeNotificationChannel(getString(R.string.notificationChannel), "Hello!")

        supportActionBar?.hide()

        topBar = topBarLogic(findViewById(R.id.conTop_bar))

        topTextChange("utforsk")

        setOnClickListeners()

        cartRepo = CartRepo()
    }

    fun setOnClickListeners(){

        topBar.cartButton.setOnClickListener{
            cartButtonLogic()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) sendNotification("Cart!", "The cart has been pressed!")
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun sendNotification(title: String, text: String){

        notificatons.sendNotif(this@MainActivity, title, text)
    }
}