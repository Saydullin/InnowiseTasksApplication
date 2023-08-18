package com.example.tasksapplication.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.tasksapplication.databinding.ColorSwitchViewBinding

class ColorSwitchView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int,
    defStyleRes: Int
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding = ColorSwitchViewBinding.inflate(LayoutInflater.from(context), this)
    private val colors = arrayOf(
        Color.RED,
        Color.GREEN,
        Color.BLUE,
        Color.YELLOW,
        Color.CYAN,
        Color.MAGENTA,
        Color.GRAY,
        Color.DKGRAY,
        Color.LTGRAY,
        Color.BLACK
    )
    private var currentIndex = 0

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    init {
        setListeners()
    }

    private fun setListeners() {
        binding.nextButton.setOnClickListener {
            currentIndex++
            checkCurrentIndexOut()
            binding.colorItem.setBackgroundColor(colors[currentIndex])
            binding.textColor.text = colors[currentIndex].toString()
        }
        binding.prevButton.setOnClickListener {
            currentIndex--
            checkCurrentIndexOut()
            binding.colorItem.setBackgroundColor(colors[currentIndex])
            binding.textColor.text = colors[currentIndex].toString()
        }
    }

    private fun checkCurrentIndexOut() {
        if (currentIndex >= colors.size) {
            currentIndex = 0
        }
        if (currentIndex < 0) {
            currentIndex = colors.size - 1
        }
    }

}