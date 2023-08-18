package com.example.tasksapplication.patterns.factory.logistic

import com.example.tasksapplication.patterns.factory.model.TransportInfo
import com.example.tasksapplication.patterns.factory.transport.Transport
import com.example.tasksapplication.patterns.factory.transport.RailwayTransport

class RussiaLogistic(
    private val transportInfo: TransportInfo
) : Logistic {

    override fun createTransport(): Transport {
        return RailwayTransport(
            companyName = transportInfo.companyName,
            maxLoadCapacity = transportInfo.maxLoadCapacity,
            maxDimension = transportInfo.maxDimension,
            trackSize = 0,
            withBallast = false
        )
    }

}