package com.example.tasksapplication.custom

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.example.tasksapplication.databinding.CounterCustomViewBinding
import com.example.tasksapplication.lifeCycle.UpdateCounterActivity

class CounterCustomView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int,
    defStyleRes: Int
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding = CounterCustomViewBinding.inflate(LayoutInflater.from(context), this)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    init {
        setListeners()
    }

    fun updateCornerRadius(radius: Float) {
        binding.counterCardView.radius = radius
    }

    fun setCounterText(text: String) {
        binding.counterTextView.text = text
    }

    private fun setListeners() {
        binding.counterTapButton.setOnClickListener {
            val intent = Intent(context, UpdateCounterActivity::class.java)
            intent.putExtra("cardRadius", binding.counterCardView.radius)
            context.startActivity(intent)
        }
    }

}


