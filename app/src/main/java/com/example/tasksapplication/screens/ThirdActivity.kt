package com.example.tasksapplication.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksapplication.databinding.ActivityThirdBinding
import com.example.tasksapplication.patterns.observer.WeatherObserver
import com.example.tasksapplication.patterns.observer.WeatherObserverUpdate

class ThirdActivity : AppCompatActivity(), WeatherObserverUpdate {
    private lateinit var weatherObserver: WeatherObserver
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weatherObserver = WeatherObserver.getInstance()
        weatherObserver.subscribe(this)

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