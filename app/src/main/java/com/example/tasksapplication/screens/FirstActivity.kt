package com.example.tasksapplication.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksapplication.databinding.ActivityFirstBinding
import com.example.tasksapplication.patterns.observer.WeatherObserver
import com.example.tasksapplication.patterns.observer.WeatherObserverUpdate

class FirstActivity : AppCompatActivity(), WeatherObserverUpdate {

    private lateinit var weatherObserver: WeatherObserver
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weatherObserver = WeatherObserver.getInstance()
        weatherObserver.subscribe(this)

        binding.nextButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
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