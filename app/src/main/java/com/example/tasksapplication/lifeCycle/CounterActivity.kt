package com.example.tasksapplication.lifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksapplication.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding
    private var labelSize = 0f
    private var lastTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            labelSize = savedInstanceState.getFloat("labelSize")
            updateLabel()
        } else {
            labelSize = binding.counterCustomView.getTitleSize()
        }

        val isRounded = intent.getFloatExtra("cardRadius", 0f)
        if (isRounded != 0f) {
            binding.counterCustomView.setCounterTitle(isRounded.toInt().toString())
            binding.counterCustomView.updateCornerRadius(isRounded)
        }
        lastTime = System.currentTimeMillis()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putFloat("labelSize", labelSize)
        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        super.onPause()
        labelSize += 5f
        lastTime = System.currentTimeMillis()

        updateLabel()
    }

    override fun onResume() {
        super.onResume()
        labelSize += 2f
        val elapsedTime = (System.currentTimeMillis() - lastTime) / 1000 / 60
        labelSize -= 2 * elapsedTime.toInt()
        updateLabel()
    }

    private fun updateLabel() {
        binding.counterCustomView.setTitleSize(labelSize)
    }

}


