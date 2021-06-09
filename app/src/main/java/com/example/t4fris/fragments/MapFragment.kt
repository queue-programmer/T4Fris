package com.example.t4fris.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t4fris.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    lateinit var googleMap: GoogleMap

    lateinit var mapFragment: SupportMapFragment

    lateinit var mapContainer: Fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_map, container, false)

        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)


        return root
    }

    override fun onMapReady(p0: GoogleMap) {

        googleMap = p0

        val pointNemo = LatLng(-48.876667, -123.393333)
        googleMap.addMarker(
            MarkerOptions()
                .position(pointNemo)
                .title("Here lies Cthulhu, sleeping.")
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(pointNemo))
    }
}