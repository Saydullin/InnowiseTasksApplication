package com.example.tasksapplication.patterns.factory.transport

data class SeaTransport(
    override val companyName: String,
    override val maxLoadCapacity: Int,
    override val maxDimension: Int,
    val type: SeaTransportType = SeaTransportType.SEA
) : Transport