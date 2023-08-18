package com.example.tasksapplication.list.model

data class User(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val sex: UserSex = UserSex.MALE,
    val squareAvatarUrl: String,
    val description: String
)


