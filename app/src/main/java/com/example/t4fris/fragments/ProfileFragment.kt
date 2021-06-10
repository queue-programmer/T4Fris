package com.example.t4fris.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.t4fris.MainActivity
import com.example.t4fris.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as MainActivity).topTextChange("profil")

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}