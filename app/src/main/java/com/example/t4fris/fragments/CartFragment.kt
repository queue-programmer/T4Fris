package com.example.t4fris.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t4fris.Adapters.CartAdapter
import com.example.t4fris.R
import com.example.t4fris.ViewModels.CartViewModel
import kotlinx.android.synthetic.main.fragment_cart.view.*

class CartFragment: Fragment() {

    lateinit var total: TextView

    lateinit var add: TextView
    lateinit var whenT: Button
    lateinit var payAndSend: Button

    lateinit var cartLay: RecyclerView

    lateinit var cartAdapter: CartAdapter
    lateinit var recyclerLayoutManager: RecyclerView.LayoutManager

    lateinit var viewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_cart, container, false)

        total = root.sumNumber

        add = root.addText
        whenT = root.whenFetch
        payAndSend = root.payandsendButton

        cartLay = root.cartLayout

        viewModel = CartViewModel()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerLayoutManager = LinearLayoutManager(context)
        cartAdapter = CartAdapter(listOf())

        cartLay.layoutManager = recyclerLayoutManager
        cartLay.adapter = cartAdapter

        viewModel.cartLiveData.observe(viewLifecycleOwner, {
            activity?.runOnUiThread {
                cartAdapter.update(it)
            }
        })

        viewModel.totalPriceLiveData.observe(viewLifecycleOwner, {
            if(it != 0) total.text = it.toString()
        })

        viewModel.getCart()

        setOnClickListeners()
    }

    fun setOnClickListeners(){

        add.setOnClickListener {
            Toast.makeText(requireContext(), "Pressed the add something button!", Toast.LENGTH_SHORT).show()
        }

        whenT.setOnClickListener {
            Toast.makeText(requireContext(), "Pressed the decide delivery time button!", Toast.LENGTH_SHORT).show()
        }

        payAndSend.setOnClickListener {
            Toast.makeText(requireContext(), "Pressed the pay and send order button!", Toast.LENGTH_SHORT).show()
        }
    }
}