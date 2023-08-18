package com.example.tasksapplication.list.utils

import com.example.tasksapplication.list.model.User

class UserDataSource {

    fun getUsers(): List<User> {
        return UserGenerator.generateRandomUsers(30) as ArrayList
    }

}