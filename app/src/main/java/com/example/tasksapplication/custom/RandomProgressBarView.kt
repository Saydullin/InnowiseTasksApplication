package com.example.tasksapplication.custom

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.tasksapplication.databinding.RandomProgressBarViewBinding

class RandomProgressBarView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int,
    defStyleRes: Int
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    val binding = RandomProgressBarViewBinding.inflate(LayoutInflater.from(context), this)
    private val progressBarView = binding.progressBar
    var prevProgress = 0
    val animator = ObjectAnimator.ofInt(progressBarView, "progress", 0, 100).apply {
        duration = 1000 // Длительность анимации в миллисекундах
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    init {
        setListeners()
    }

    private fun setListeners() {
        binding.animateButton.setOnClickListener {
            val randomProgress = (10..100).random()
            binding.progressBar.progress = randomProgress
            binding.progressBarText.text = randomProgress.toString()
            animator.setIntValues(prevProgress, randomProgress)
            animator.start()
            prevProgress = randomProgress
        }
    }

}