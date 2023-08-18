package com.example.tasksapplication.patterns.factory.transport

data class MotorTransport(
    override val companyName: String,
    override val maxLoadCapacity: Int,
    override val maxDimension: Int
) : Transport