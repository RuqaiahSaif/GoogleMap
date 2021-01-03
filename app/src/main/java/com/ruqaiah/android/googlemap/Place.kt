package com.ruqaiah.android.googlemap

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
data class Place(@PrimaryKey val id: UUID = UUID.randomUUID(),
                 var name:String=""
                 , var address:String=""
                 , var lat:Double=0.0,
                 var lng:Double=0.0,
                 var type:String=""
): Serializable {
}