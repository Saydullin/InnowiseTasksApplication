package com.example.tasksapplication.patterns.observer

import android.os.Handler
import android.os.Looper
import java.util.Date
import java.util.Timer
import java.util.TimerTask

class WeatherObserver private constructor() {

    private val observers: ArrayList<WeatherObserverUpdate> = arrayListOf()
    private var temperature: String = ""

    private val timer = Timer()
    private val handler = Handler(Looper.getMainLooper())

    init {
        timer.schedule(object : TimerTask() {
            override fun run() {
                getWeatherData()
            }
        }, 0, 5000)
    }

    companion object {
        private var instance: WeatherObserver? = null

        fun getInstance(): WeatherObserver {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = WeatherObserver()
                    }
                }
            }
            return instance!!
        }
    }

    private fun getWeatherData() {
        val weatherData = (Date().time / 1000) % 35
        temperature = "Weather is $weatherData"

        handler.post {
            notifyObservers()
        }
    }

    private fun notifyObservers() {
        for (observer in observers) {
            observer.onWeatherUpdate(temperature)
        }
    }

    fun subscribe(observer: WeatherObserverUpdate) {
        observers.add(observer)
        observer.onWeatherUpdate(temperature)
    }

    fun unsubscribe(observer: WeatherObserverUpdate) {
        observers.remove(observer)
    }

}