package com.example.tasksapplication.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksapplication.databinding.ActivitySecondBinding
import com.example.tasksapplication.patterns.observer.WeatherObserver
import com.example.tasksapplication.patterns.observer.WeatherObserverUpdate

class SecondActivity : AppCompatActivity(), WeatherObserverUpdate {
    private lateinit var weatherObserver: WeatherObserver
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weatherObserver = WeatherObserver.getInstance()
        weatherObserver.subscribe(this)

        binding.nextButton.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.prevButton.setOnClickListener {
            finish()
        }
    }

    override fun onWeatherUpdate(temp: String) {
        binding.text.text = temp
    }

    override fun onDestroy() {
        super.onDestroy()
        weatherObserver.unsubscribe(this)
    }
}