package com.example.tasksapplication.design.dynamic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.tasksapplication.R
import com.example.tasksapplication.databinding.ActivityAddAlphaAndRemoveAlphaBinding

class AddAlphaAndRemoveAlphaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddAlphaAndRemoveAlphaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load("https://s1.stc.all.kpcdn.net/family/wp-content/uploads/2023/02/top-v-luchshie-porody-krupnykh-sobak-960x540-1-960x540.jpg")
            .placeholder(R.color.blue)
            .into(binding.dynamicImage)

        binding.addAlphaButton.setOnClickListener {
            if (binding.dynamicImage.alpha < 1f) {
                val alpha = binding.dynamicImage.alpha + 0.1f
                binding.dynamicImage.animate().alpha(alpha).setDuration(200).start()
            }
        }

        binding.removeAlphaButton.setOnClickListener {
            if (binding.dynamicImage.alpha > 0f) {
                val alpha = binding.dynamicImage.alpha - 0.1f
                binding.dynamicImage.animate().alpha(alpha).setDuration(200).start()
            }
        }
    }

}