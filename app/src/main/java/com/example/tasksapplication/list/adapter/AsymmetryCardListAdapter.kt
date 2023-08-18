package com.example.tasksapplication.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasksapplication.databinding.ListCardItemBinding

class AsymmetryCardListAdapter(
    val context: Context,
    private val texts: List<String>,
    private val colors: List<Int>
): RecyclerView.Adapter<AsymmetryCardListAdapter.ViewHolder>() {

    class ViewHolder(
        listCardItemBinding: ListCardItemBinding
    ): RecyclerView.ViewHolder(listCardItemBinding.root) {
        private val binding = listCardItemBinding

        fun bind(text: String, color: Int) {
            binding.cardText.text = text
            binding.cardHolder.setBackgroundColor(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListCardItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = maxOf(texts.size, colors.size)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text = texts[texts.size % (position + 1)]
        val color = colors[colors.size % (position + 1)]

        holder.bind(text, color)
    }

}