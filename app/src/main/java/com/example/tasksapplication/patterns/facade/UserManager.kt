package com.example.tasksapplication.patterns.facade

class UserManager(
    private val apiManager: ApiManager,
    private val cacheManager: CacheManager
) {

    fun getUserData(): String {
        val cache = cacheManager.getUserData()

        return if (cache != null) {
            cache
        } else {
            val apiData = apiManager.getUserData()
            cacheManager.saveUserData(apiData)
            apiData
        }
    }

}