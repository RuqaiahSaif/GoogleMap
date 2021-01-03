package com.ruqaiah.android.googlemap

import android.app.Application

class PlaceApplication : Application(){
    override fun onCreate() {
        super.onCreate()
       PlaceRepositry.initialize(this)
    }
}
