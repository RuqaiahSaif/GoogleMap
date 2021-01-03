package DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ruqaiah.android.googlemap.Place

@Database(entities = [ Place::class ], version=1)
@TypeConverters(PlaceTypeConverters::class)
abstract class PlaceDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao}