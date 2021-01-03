package com.ruqaiah.android.googlemap.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.ruqaiah.android.googlemap.Place
import com.ruqaiah.android.googlemap.PlaceViewModel
import com.ruqaiah.android.googlemap.R
import java.util.*

val place_type= arrayOf("school","hosptial","mylocation")

class HomeFragment : Fragment()  {
lateinit var name:EditText
    lateinit var address:EditText

    private val placeViewModel: PlaceViewModel by lazy {
        ViewModelProviders.of(this).get(PlaceViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val spinner = root.findViewById<Spinner>(R.id.simplespinner)
        spinner.adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.support_simple_spinner_dropdown_item, place_type) } as SpinnerAdapter
        spinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("erreur")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var type = parent?.getItemAtPosition(position).toString()
                Toast.makeText(activity,type, Toast.LENGTH_LONG).show()
                println(type)
            }

        }

        name=root.findViewById(R.id.name)
        address=root.findViewById(R.id.address)
 val hight_line: EditText =root.findViewById(R.id.h)
      val  weight_line:EditText=root.findViewById(R.id.w )
        val fab: FloatingActionButton =root.findViewById(R.id.fab)
        fab?.setOnClickListener {
            if(name!=null && address!=null && hight_line!=null && weight_line!=null){
                var hight = hight_line.text.toString().trim().toDouble()
                var weight:Double = weight_line.text.toString().trim().toDouble()
            placeViewModel.addPlace(Place(UUID.randomUUID(),name.text.toString(),address.text.toString(),hight,weight, spinner.getSelectedItem().toString()))
        }
            Toast.makeText(activity,"insert all fields", Toast.LENGTH_LONG).show()

        }


        return root
    }


}