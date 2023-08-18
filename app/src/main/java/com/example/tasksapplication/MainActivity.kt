package com.example.tasksapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tasksapplication.databinding.ActivityMainBinding
import com.example.tasksapplication.design.CenteringActivity
import com.example.tasksapplication.design.CustomProgressBarActivity
import com.example.tasksapplication.design.CustomViewActivity
import com.example.tasksapplication.design.DynamicActivity
import com.example.tasksapplication.design.ProfileActivity
import com.example.tasksapplication.design.ScrollViewActivity
import com.example.tasksapplication.design.ZActivity
import com.example.tasksapplication.list.ListActivity
import com.example.tasksapplication.patterns.builder.Coffee
import com.example.tasksapplication.patterns.facade.ApiManager
import com.example.tasksapplication.patterns.facade.CacheManager
import com.example.tasksapplication.patterns.facade.UserManager
import com.example.tasksapplication.patterns.factory.LogisticFactory
import com.example.tasksapplication.patterns.factory.model.TransportInfo
import com.example.tasksapplication.patterns.singleton.Sun
import com.example.tasksapplication.screens.FirstActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Builder
        val coffee = Coffee.Builder()
            .milk(true)
            .sugar(false)
            .build()

        // Singleton
        val sun = Sun.getInstance()

        // FactoryMethod
        val transportInfo = TransportInfo(
            1,
            "CName",
            2,
            3
        )
        val logisticFactory = LogisticFactory(
            countryCode = "DE",
            transportInfo = transportInfo
        )
        val logistic = logisticFactory.getLogistic()
        val transport = logistic.createTransport()
        Toast.makeText(applicationContext, transport.companyName, Toast.LENGTH_SHORT).show()

        // Facade
        val apiManager = ApiManager()
        val cacheManager = CacheManager()
        val userManager = UserManager(apiManager, cacheManager)
        val apiData = userManager.getUserData()
        val cacheData = userManager.getUserData()

        binding.observerPattern.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }
        binding.itemsAndButton.setOnClickListener {
            val intent = Intent(this, CenteringActivity::class.java)
            startActivity(intent)
        }
        binding.profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.zOrderButton.setOnClickListener {
            val intent = Intent(this, ZActivity::class.java)
            startActivity(intent)
        }
        binding.scrollViewButton.setOnClickListener {
            val intent = Intent(this, ScrollViewActivity::class.java)
            startActivity(intent)
        }
        binding.dynamicButton.setOnClickListener {
            val intent = Intent(this, DynamicActivity::class.java)
            startActivity(intent)
        }
        binding.customViewButton.setOnClickListener {
            val intent = Intent(this, CustomViewActivity::class.java)
            startActivity(intent)
        }
        binding.customProgressViewButton.setOnClickListener {
            val intent = Intent(this, CustomProgressBarActivity::class.java)
            startActivity(intent)
        }
        binding.usersListButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

    }

}