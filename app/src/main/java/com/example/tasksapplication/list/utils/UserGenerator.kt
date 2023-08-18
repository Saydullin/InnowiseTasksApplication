package com.example.tasksapplication.list.utils

import com.example.tasksapplication.list.model.User
import com.example.tasksapplication.list.model.UserSex
import kotlin.random.Random

class UserGenerator {

    companion object {
        private fun generateRandomUser(): User {
            val firstName = listOf("John", "Alice", "Michael", "Emma", "David", "Olivia").random()
            val lastName = listOf("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis").random()
            val age = Random.nextInt(18, 65)
            val sex = if (Random.nextBoolean()) UserSex.MALE else UserSex.FEMALE
            val squareAvatarUrl = "https://thispersondoesnotexist.com/"
            val description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."

            return User(firstName, lastName, age, sex, squareAvatarUrl, description)
        }

        fun generateRandomUsers(count: Int): List<User> {
            val users = mutableListOf<User>()
            repeat(count) {
                users.add(generateRandomUser())
            }
            return users
        }
    }

}