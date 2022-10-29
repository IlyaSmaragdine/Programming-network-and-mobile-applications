package com.example.myapplication

class Pickup(color:String) : CarBase(2, 6, color), IHasSpotlight {
    override fun beep() : String {
        return "Yak pomry to pohovaite"
    }

    var small_spotlight_on: Boolean = false;
    override fun toggle_spotlight(on: Boolean) : String {
        small_spotlight_on = on;
        return "current small spotlight state: ${if (on) "on" else "off"}";
    }
}
