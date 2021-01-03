package DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ruqaiah.android.googlemap.Place
import java.util.*

@Dao
interface PlaceDao {

    @Query("SELECT * FROM place")
    fun getPlaces(): LiveData<List<Place>>
    @Query("SELECT * FROM place WHERE type=(:type)")
    fun getPlace(type: String):List<Place>
    @Insert
    fun addPlace(place: Place)
}