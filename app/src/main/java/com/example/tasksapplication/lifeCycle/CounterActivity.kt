package com.example.tasksapplication.lifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tasksapplication.R
import com.example.tasksapplication.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val isRounded = intent.getFloatExtra("cardRadius", 0f)
        if (isRounded != 0f) {
            binding.counterCustomView.setCounterText(isRounded.toInt().toString())
            binding.counterCustomView.updateCornerRadius(isRounded)
        }
    }
}


