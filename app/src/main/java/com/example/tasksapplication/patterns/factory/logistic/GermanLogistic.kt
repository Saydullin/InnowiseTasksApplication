package com.example.tasksapplication.patterns.factory.logistic

import com.example.tasksapplication.patterns.factory.model.TransportInfo
import com.example.tasksapplication.patterns.factory.transport.Transport
import com.example.tasksapplication.patterns.factory.transport.AirTransport

class GermanLogistic(
    private val transportInfo: TransportInfo
) : Logistic {

    override fun createTransport(): Transport {
        return AirTransport(
            companyName = transportInfo.companyName,
            maxLoadCapacity = transportInfo.maxLoadCapacity,
            maxDimension = transportInfo.maxDimension
        )
    }

}