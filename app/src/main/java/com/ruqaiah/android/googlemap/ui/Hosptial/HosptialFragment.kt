package com.ruqaiah.android.googlemap.ui.Hosptial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ruqaiah.android.googlemap.PlaceViewModel
import com.ruqaiah.android.googlemap.R

class HosptialFragment : Fragment() , OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val placeViewModel: PlaceViewModel by lazy {
        ViewModelProviders.of(this).get(PlaceViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_hosptial, container, false)
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.hosptial) as SupportMapFragment?

        mapFragment!!.getMapAsync(this)


        return root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        var hosptials = placeViewModel.getPlace("hosptial")

        for (place in hosptials) {
            var placeLatLng = LatLng(place.lat, place.lng)
            mMap.addMarker(MarkerOptions().position(placeLatLng).title(place.name).snippet(place.address))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placeLatLng, 14.0F))
        }
    }
}