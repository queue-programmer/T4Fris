package com.example.t4fris.MapThings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.t4fris.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

//class MapsMarkerActivity: AppCompatActivity(), OnMapReadyCallback {

//    private lateinit var frisMap: GoogleMap
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_map)
//
//        val mapFragment = MapFragment.findFragmentById(R.id.map) as? SupportMapFragment
//        mapFragment?.getMapAsync(this)
//    }
//
//    override fun onMapReady(p0: GoogleMap) {
//        val oslo = LatLng(59.9, 10.7)
//        googleMap.addMarker(
//            MarkerOptions()
//                .position(oslo)
//                .title("Marker is in Oslo")
//        )
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(oslo))
//    }
//}

//class MapsMarkerActivity : AppCompatActivity(), OnMapReadyCallback {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        // Retrieve the content view that renders the map.
//        setContentView(R.layout.activity_maps)
//
//        // Get the SupportMapFragment and request notification when the map is ready to be used.
//        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
//        mapFragment?.getMapAsync(this)
//    }
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        val sydney = LatLng(-33.852, 151.211)
//        googleMap.addMarker(
//            MarkerOptions()
//                .position(sydney)
//                .title("Marker in Sydney")
//        )
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//    }

