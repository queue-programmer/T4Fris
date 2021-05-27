package com.example.t4fris.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.t4fris.MainActivity
import com.example.t4fris.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_explore, container, false)
//        (activity as MainActivity).topTextChange("utforsk")

        return root
    }


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        (activity as MainActivity).topTextChange("utforsk")
//
//
//        return inflater.inflate(R.layout.fragment_explore, container, false)
//    }

}