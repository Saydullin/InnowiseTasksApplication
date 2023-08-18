package com.example.tasksapplication.patterns.factory.logistic

import com.example.tasksapplication.patterns.factory.transport.Transport

interface Logistic {

    fun createTransport(): Transport

}