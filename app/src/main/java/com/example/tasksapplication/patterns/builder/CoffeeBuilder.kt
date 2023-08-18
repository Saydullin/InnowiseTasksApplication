package com.example.tasksapplication.patterns.builder

interface CoffeeBuilder<T, E> {
    fun double(isDouble: Boolean): T
    fun milk(isMilk: Boolean): T
    fun cream(isCream: Boolean): T
    fun sugar(isSugar: Boolean): T
    fun cinnamon(isCinnamon: Boolean): T
    fun syrup(isSyrup: Boolean): T

    fun build(): E
}


