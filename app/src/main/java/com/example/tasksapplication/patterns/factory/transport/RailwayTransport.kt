package com.example.tasksapplication.patterns.factory.transport

data class RailwayTransport(
    override val companyName: String,
    override val maxLoadCapacity: Int,
    override val maxDimension: Int,
    val trackSize: Int,
    val withBallast: Boolean,
) : Transport


