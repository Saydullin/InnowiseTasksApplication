package com.example.tasksapplication.design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksapplication.R
import com.example.tasksapplication.databinding.ActivityDynamicBinding
import com.example.tasksapplication.design.dynamic.AddAlphaAndRemoveAlphaActivity
import com.example.tasksapplication.design.dynamic.AddAndRemoveActivity
import com.example.tasksapplication.design.dynamic.HideAndShowActivity

class DynamicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDynamicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAddAndRemove.setOnClickListener {
            val intent = Intent(this, AddAndRemoveActivity::class.java)
            startActivity(intent)
        }

        binding.buttonHideAndShow.setOnClickListener {
            val intent = Intent(this, HideAndShowActivity::class.java)
            startActivity(intent)
        }

        binding.buttonAddAlphaAndRemoveAlpha.setOnClickListener {
            val intent = Intent(this, AddAlphaAndRemoveAlphaActivity::class.java)
            startActivity(intent)
        }
    }

}