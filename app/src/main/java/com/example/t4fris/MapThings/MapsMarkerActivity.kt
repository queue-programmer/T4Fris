package com.example.t4fris.MapThings

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.OnMapReadyCallback



//    import android.os.Bundle
//    import android.widget.Toast
//    import androidx.appcompat.app.AppCompatActivity
//    import com.google.android.gms.maps.CameraUpdateFactory
//    import com.google.android.gms.maps.GoogleMap
//    import com.google.android.gms.maps.OnMapReadyCallback
//    import com.google.android.gms.maps.SupportMapFragment
//    import com.google.android.gms.maps.model.LatLng
//    import com.google.android.gms.maps.model.MarkerOptions

class MapsMarkerActivity: AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    }

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // Retrieve the content view that renders the map.
    setContentView(R.layout.activity_maps)

    // Get the SupportMapFragment and request notification when the map is ready to be used.
    val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
    mapFragment?.getMapAsync(this)
}

override fun onMapReady(googleMap: GoogleMap) {
    val sydney = LatLng(-33.852, 151.211)
    googleMap.addMarker(
        MarkerOptions()
            .position(sydney)
            .title("Marker in Sydney")
    )
    googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
}
