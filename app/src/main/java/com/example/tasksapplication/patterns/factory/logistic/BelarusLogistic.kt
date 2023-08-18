package com.example.tasksapplication.patterns.factory.logistic

import com.example.tasksapplication.patterns.factory.model.TransportInfo
import com.example.tasksapplication.patterns.factory.transport.Transport
import com.example.tasksapplication.patterns.factory.transport.MotorTransport

class BelarusLogistic(
    private val transportInfo: TransportInfo
) : Logistic {

    override fun createTransport(): Transport {
        return MotorTransport(
            companyName = transportInfo.companyName,
            maxLoadCapacity = transportInfo.maxLoadCapacity,
            maxDimension = transportInfo.maxDimension
        )
    }

}