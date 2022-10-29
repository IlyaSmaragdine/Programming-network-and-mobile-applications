package com.example.myapplication

abstract class CarBase(val doors: Int, val lights: Int, val color: String) {
    var lights_on: Boolean = false;
    fun toggle_lights (on: Boolean) : String {
        lights_on = on;
        return "current lights state: ${if (on) "on" else "off"}";
    }

    abstract fun beep() : String;
}

