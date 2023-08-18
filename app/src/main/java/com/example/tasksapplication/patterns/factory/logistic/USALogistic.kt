package com.example.tasksapplication.patterns.factory.logistic

import com.example.tasksapplication.patterns.factory.model.TransportInfo
import com.example.tasksapplication.patterns.factory.transport.Transport
import com.example.tasksapplication.patterns.factory.transport.SeaTransport

class USALogistic(
    private val transportInfo: TransportInfo
) : Logistic {

    override fun createTransport(): Transport {
        return SeaTransport(
            companyName = transportInfo.companyName,
            maxLoadCapacity = transportInfo.maxLoadCapacity,
            maxDimension = transportInfo.maxDimension
        )
    }

}