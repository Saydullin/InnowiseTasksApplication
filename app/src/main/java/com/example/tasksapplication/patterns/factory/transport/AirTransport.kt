package com.example.tasksapplication.patterns.factory.transport

data class AirTransport(
    override val companyName: String,
    override val maxLoadCapacity: Int,
    override val maxDimension: Int,
    val type: AirTransportType = AirTransportType.INTERNATIONAL,
    val transport: AirTransportShipType = AirTransportShipType.PASSENGER
) : Transport


