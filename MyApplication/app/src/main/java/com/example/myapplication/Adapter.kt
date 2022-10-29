package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val context: Context, private val cars: List<CarBase>) : RecyclerView.Adapter<Adapter.CarRecyclerHolder>() {

    private val onMessage: (String, String) -> Unit = { header, text ->

        val builder = AlertDialog.Builder(context)

        with(builder) {

            setTitle(header)

            setMessage(text)

            setPositiveButton("OK", null)

            show()

        }

    }

    private val onLights: (CarBase, Boolean) -> Unit = { car, on -> onMessage("${car.javaClass.simpleName} makes action:", car.toggle_lights(on)) }

    private val onSpotLights: (IHasSpotlight, Boolean) -> Unit = { car, on -> onMessage("${car.javaClass.simpleName} makes action:", car.toggle_spotlight(on)) }
    private val onBeep: (CarBase) -> Unit = { car -> onMessage("${car.javaClass.simpleName} makes sound:", car.beep()) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarRecyclerHolder =
        CarRecyclerHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.car_recycler_item, parent, false))

    override fun onBindViewHolder(holder: CarRecyclerHolder, position: Int) {

        val car = cars[position];

        holder.carType.text = car.javaClass.simpleName
        holder.carDoors.text = "Doors: " + car.doors.toString()                                                 //car.javaClass.simpleName
        holder.carLights.text = "Lights: " + car.lights.toString()
        holder.carColor.text = "Color: " + car.color

        holder.carBeep.setOnClickListener { onBeep(car) }
        holder.changeLights.setOnClickListener { onLights(car, !car.lights_on) }

        if(car is IHasSpotlight) {
            val on : Boolean = if(car is Pickup) car.small_spotlight_on else if(car is Truck) car.big_spotlight_on else false
            holder.changeSpotlights.setOnClickListener { onSpotLights(car, !on) }

        } else {

            holder.changeSpotlights.visibility = View.GONE

        }

    }

    override fun getItemCount(): Int = cars.size

    class CarRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val carType: TextView = itemView.findViewById(R.id.type)
        val carDoors: TextView = itemView.findViewById(R.id.doors)
        val carLights: TextView = itemView.findViewById(R.id.lights)
        val carColor: TextView = itemView.findViewById(R.id.color)

        val changeLights: Button = itemView.findViewById(R.id.change_lights)
        val changeSpotlights: Button = itemView.findViewById(R.id.change_spotlights)
        val carBeep: Button = itemView.findViewById(R.id.press_beep)


    }

}