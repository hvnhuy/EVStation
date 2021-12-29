package com.humaxdigital.ev_charging_station.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.humaxdigital.ev_charging_station.R

import com.humaxdigital.ev_charging_station.databinding.ActivityMapsBinding
import com.humaxdigital.ev_charging_station.viewmodel.MapViewModel
import com.humaxdigital.ev_charging_station.base.BaseActiviy

class MapsActivity : BaseActiviy<ActivityMapsBinding, MapViewModel>(), OnMapReadyCallback {

    private lateinit var naviController: NavController
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayOutID(): Int {
        return R.layout.activity_maps
    }

    override fun getViewModel(): Class<MapViewModel> {
        return MapViewModel::class.java
    }

    override fun initView() {
        binding.viewModel = this
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onClick(view: View) {
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
    }

}