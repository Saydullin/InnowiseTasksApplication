package com.example.tasksapplication.design.dynamic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.tasksapplication.R
import com.example.tasksapplication.databinding.ActivityHideAndShowBinding

class HideAndShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHideAndShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load("https://s1.stc.all.kpcdn.net/family/wp-content/uploads/2023/02/top-v-luchshie-porody-krupnykh-sobak-960x540-1-960x540.jpg")
            .placeholder(R.color.blue)
            .into(binding.dynamicImage)

        binding.hideButton.setOnClickListener {
            binding.dynamicImage.visibility = View.GONE
            binding.hiddenText.visibility = View.VISIBLE
        }

        binding.showButton.setOnClickListener {
            binding.dynamicImage.visibility = View.VISIBLE
            binding.hiddenText.visibility = View.GONE
        }
    }

}