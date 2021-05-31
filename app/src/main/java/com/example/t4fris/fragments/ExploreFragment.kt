package com.example.t4fris.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.t4fris.MainActivity
import com.example.t4fris.R
import com.example.t4fris.cutomLogic.IcecreamData
import kotlinx.android.synthetic.main.fragment_explore.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    lateinit var strawberryIce: Button
    lateinit var vanillaIce: Button
    lateinit var chocolateIce: Button
    lateinit var blackberryIce: Button

        override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_explore, container, false)

            strawberryIce = root.strawB
            vanillaIce = root.vanilla
            chocolateIce = root.choco
            blackberryIce = root.blackB

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickListeners()
    }

    fun setOnClickListeners(){
        strawberryIce.setOnClickListener{
            val icecream = IcecreamData("JordbærIs", 69)
            addToCart(icecream)
        }
        vanillaIce.setOnClickListener{
            val icecream = IcecreamData("VaniljeIs", 69)
            addToCart(icecream)
        }
        chocolateIce.setOnClickListener{
            val icecream = IcecreamData("SjokoladeIs", 69)
            addToCart(icecream)
        }
        blackberryIce.setOnClickListener{
            val icecream = IcecreamData("BjørnebærIs", 69)
            addToCart(icecream)
        }
    }

    fun addToCart(icecream:IcecreamData){

        CoroutineScope(Dispatchers.IO).launch {
            (activity as MainActivity).cartRepo.addToCart(icecream.name, icecream.price)
        }
        Toast.makeText((activity as MainActivity).applicationContext, "Added ${icecream.name} to cart", Toast.LENGTH_SHORT).show()
    }
}