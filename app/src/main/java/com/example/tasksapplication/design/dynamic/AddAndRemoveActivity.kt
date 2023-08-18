package com.example.tasksapplication.design.dynamic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.tasksapplication.R
import com.example.tasksapplication.databinding.ActivityAddAndRemoveBinding
import kotlin.random.Random

class AddAndRemoveActivity : AppCompatActivity() {

    private val viewsList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddAndRemoveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load("https://s1.stc.all.kpcdn.net/family/wp-content/uploads/2023/02/top-v-luchshie-porody-krupnykh-sobak-960x540-1-960x540.jpg")
            .placeholder(R.color.blue)
            .into(binding.dynamicImage)

        val imageParentContainer: ViewGroup = binding.dynamicImage.parent as ViewGroup

        binding.addButton.setOnClickListener {
            val newView = View(this)
            newView.layoutParams = binding.dynamicImage.layoutParams
            newView.background = binding.dynamicImage.background

            val newViewWidth = newView.layoutParams.width
            val parentContainerWidth = imageParentContainer.width
            val remainingWidth = parentContainerWidth - calculateOccupiedWidth()
            if (newViewWidth <= remainingWidth) {
                viewsList.add(newView)
                imageParentContainer.addView(newView)
            } else {
                Toast.makeText(this, "Not enough width", Toast.LENGTH_SHORT).show()
            }
        }

        binding.removeButton.setOnClickListener {
            if (viewsList.isNotEmpty()) {
                imageParentContainer.removeView(viewsList.last())
                viewsList.remove(viewsList.last())
            }
        }
    }

    private fun calculateOccupiedWidth(): Int {
        var occupiedWidth = 0
        for (view in viewsList) {
            occupiedWidth += view.layoutParams.width
        }
        return occupiedWidth
    }

}