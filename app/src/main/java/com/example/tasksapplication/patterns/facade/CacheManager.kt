package com.example.tasksapplication.patterns.facade

class CacheManager {

    private var cacheData: String? = null

    fun getUserData(): String? {
        return cacheData
    }

    fun saveUserData(data: String) {
        cacheData = data
    }

}