package com.example.myapplication

class PassengerCar(color:String) : CarBase(4, 2, color) {
    override fun beep() : String {
        return "Chervonyy routy ne shykay vechorami"
    }
}