package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val cars: MutableList<CarBase> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carRecycler: RecyclerView = findViewById(R.id.car_recycler)

        carRecycler.layoutManager = LinearLayoutManager(this)
        carRecycler.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        for (i in 0..20) {

            when(Random.nextInt(0, 3)) {

                0 -> cars.add(PassengerCar(randomcolor()))
                1 -> cars.add(Truck(randomcolor()))
                2 -> cars.add(Pickup(randomcolor()))

            }

        }

        carRecycler.adapter = Adapter(this, cars)
    }
    fun randomcolor() : String {
        return String.format("#%06x", Random.nextInt(256*256*256))
    }
}