package com.example.tasksapplication.design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.tasksapplication.R
import com.example.tasksapplication.databinding.ActivityProfileBinding
import com.example.tasksapplication.design.profile.Profile
import com.example.tasksapplication.design.profile.ProfilesList
import java.util.Timer
import java.util.TimerTask

class ProfileActivity : AppCompatActivity() {

    private val timer = Timer()
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var binding: ActivityProfileBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            timer.cancel()
            finish()
        }

        initTimer()
    }

    private fun initTimer() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post {
                    updateProfile()
                }
            }
        }, 0, 5000)
    }

    fun updateProfile() {
        val profilesList = ProfilesList.getList()
        updateProfileUI(profilesList[counter])

        if (counter >= profilesList.size-1) {
            counter = 0
        } else {
            counter++
        }
    }

    private fun updateProfileUI(profile: Profile) {
        with (binding) {
            profileTitle.text = profile.title
            profileViews.text = profile.views.toString()
            profileLikes.text = profile.likes.toString()
            profileName.text = profile.fullName
            profileComments.text = profile.comments.toString()
            profileOnlineStatus.text = profile.lastTimeOnline
        }
    }

}