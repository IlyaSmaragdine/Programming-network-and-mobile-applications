package com.example.myapplication

class Truck(color:String) : CarBase(2, 8, color), IHasSpotlight {
    override fun beep() : String {
        return "Slava Ukraine"
    }

    var big_spotlight_on: Boolean = false;
    override fun toggle_spotlight(on: Boolean) : String {
        big_spotlight_on = on;
        return "current big spotlight state: ${if (on) "on" else "off"}" ;
    }
}