package com.hfad.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)          // Specifies which Layout the Activity utilizes
                                                        // activity_main == activity_main.xml
        initialize()
    }

    private fun initialize() {
        val findBeer = findViewById<Button>(R.id.find_beer)

        findBeer.setOnClickListener {
            // LAMBDA STARTS

            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val selectedColor = beerColor.selectedItem

            val brands = findViewById<TextView>(R.id.brands)
            brands.text = "Color is $selectedColor"     // selectedColor is actually called as
                                                        // selectedColor.toString() because is called from
                                                        // String Template == ` `

            // LAMBDA ENDS

            val beerList = getBeers(selectedColor.toString())

            val beers = beerList.reduce {str, item -> str + '\n' + item}
            val brands2 = findViewById<TextView>(R.id.brands2)
            brands2.text = beers
        }

    }

    private fun getBeers(color: String): List<String> {
        return when(color) {
            "Light" -> listOf("Jail Pale", "Larger Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stour", "Dark Daniel")
        }
    }

}