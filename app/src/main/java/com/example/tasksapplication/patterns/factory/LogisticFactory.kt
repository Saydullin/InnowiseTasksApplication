package com.example.tasksapplication.patterns.factory

import com.example.tasksapplication.patterns.factory.logistic.BelarusLogistic
import com.example.tasksapplication.patterns.factory.logistic.GermanLogistic
import com.example.tasksapplication.patterns.factory.logistic.Logistic
import com.example.tasksapplication.patterns.factory.logistic.RussiaLogistic
import com.example.tasksapplication.patterns.factory.logistic.USALogistic
import com.example.tasksapplication.patterns.factory.model.TransportInfo
import java.lang.Exception

class LogisticFactory(
    private val countryCode: String,
    private val transportInfo: TransportInfo
) {

    fun getLogistic(): Logistic {

        return when(countryCode) {
            "US" -> USALogistic(transportInfo)
            "RU" -> RussiaLogistic(transportInfo)
            "DE" -> GermanLogistic(transportInfo)
            "BY" -> BelarusLogistic(transportInfo)
            else -> {
                throw Exception("Unknown country")
            }
        }
    }

}