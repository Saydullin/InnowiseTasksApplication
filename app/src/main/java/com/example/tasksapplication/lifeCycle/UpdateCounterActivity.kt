package com.example.tasksapplication.lifeCycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksapplication.databinding.ActivityUpdateCounterBinding

class UpdateCounterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUpdateCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cancelButton.setOnClickListener {
            finish()
        }

        binding.updateButton.setOnClickListener {
            val newIntent = Intent(this, CounterActivity::class.java)
            val cardRadius = intent.getFloatExtra("cardRadius", 0f)
            newIntent.putExtra("cardRadius", cardRadius + 10f)
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(newIntent)
            finish()
        }

    }

}