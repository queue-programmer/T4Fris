package com.example.t4fris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.t4fris.fragments.FriscardFragment
import com.example.t4fris.fragments.HomeFragment
import com.example.t4fris.fragments.MapFragment
import com.example.t4fris.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exploreFragment = HomeFragment()
        val friscardFragment = FriscardFragment()
        val mapFragment = MapFragment()
        val profileFragment = ProfileFragment()

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.itemIconTintList = null
        val navController = findNavController(R.id.navHostFrag)
        navView.setupWithNavController(navController)

        supportActionBar?.hide()

        //makeCurrentFragment(exploreFragment)

        /*bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_explore -> makeCurrentFragment(exploreFragment)
                R.id.ic_friscard -> makeCurrentFragment(friscardFragment)
                R.id.ic_map -> makeCurrentFragment(mapFragment)
                R.id.ic_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }*/
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}