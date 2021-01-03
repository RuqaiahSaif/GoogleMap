package com.ruqaiah.android.googlemap

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class PlaceViewModel:ViewModel() {
    private val placeRepository =PlaceRepositry.get()
    fun  getPlace(type:String):List<Place> {
      return  placeRepository.getPlace(type)
    }
    fun addPlace(place: Place) {
        placeRepository.addPlace(place)
    }
}