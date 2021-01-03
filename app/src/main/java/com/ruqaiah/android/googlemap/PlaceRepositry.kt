package com.ruqaiah.android.googlemap

import DataBase.PlaceDatabase
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.util.concurrent.Executors
private const val DATABASE_NAME = "place-database"
class PlaceRepositry private constructor(context: Context) {
    private val database: PlaceDatabase = Room.databaseBuilder(
        context.applicationContext,
        PlaceDatabase::class.java,
        DATABASE_NAME
    ).allowMainThreadQueries().build()
    private val placeDao = database.placeDao()
    fun getPlaces(): LiveData<List<Place>> = placeDao.getPlaces()
    fun getPlace(type: String): List<Place> = placeDao.getPlace(type)
    private val executor = Executors.newSingleThreadExecutor()

    fun addPlace(place: Place) {
        executor.execute {
            placeDao.addPlace(place)
        }
    }
    companion object {
        private  var INSTANCE: PlaceRepositry? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = PlaceRepositry(context)
            }
        }
        fun get(): PlaceRepositry {
            return INSTANCE ?:
            throw IllegalStateException("PlaceRepositry must be initialized")
        }
    }
}
