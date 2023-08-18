package com.example.tasksapplication.patterns.observer

interface WeatherObserverUpdate {
    fun onWeatherUpdate(temp: String)
}