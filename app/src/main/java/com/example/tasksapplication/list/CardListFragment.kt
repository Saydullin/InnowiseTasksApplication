package com.example.tasksapplication.list

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasksapplication.R
import com.example.tasksapplication.databinding.FragmentCardListBinding
import com.example.tasksapplication.list.adapter.CardListAdapter
import com.example.tasksapplication.list.adapter.UserCardListAdapter

class CardListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCardListBinding.inflate(layoutInflater)

        val randomTexts = listOf(
            "MY CAREMANAGER",
            "MY DOCTOR",
            "MY DIAGNOSIS",
            "MY ORDERS",
            "REMAINING PILLS",
            "THERAPY PLAN",
            "MEDICATION REMINDER",
            "APPOINTMENT SCHEDULE",
            "HEALTH MONITORING",
            "SYMPTOM TRACKER",
            "FITNESS ROUTINE",
            "NUTRITION PLAN",
            "WELLNESS TIPS",
            "SELF-CARE STRATEGIES",
            "STRESS MANAGEMENT",
            "SLEEP TRACKER",
            "GOAL SETTING",
            "DAILY JOURNAL",
            "PROGRESS REPORT",
            "COMMUNITY SUPPORT"
        )
        val randomColors = listOf(
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.MAGENTA,
            Color.CYAN,
            Color.WHITE,
            Color.BLACK,
            Color.GRAY,
            Color.LTGRAY,
            Color.DKGRAY,
            Color.rgb(255, 165, 0),
            Color.rgb(132, 255, 10),
            Color.rgb(128, 0, 128),
            Color.rgb(255, 192, 203),
            Color.rgb(0, 128, 128),
            Color.rgb(0, 255, 0),
            Color.rgb(255, 255, 0),
            Color.rgb(0, 0, 128),
            Color.rgb(120, 60, 28)
        )
        binding.userCardListRecyclerView.adapter = CardListAdapter(requireContext(), randomTexts, randomColors)
        binding.userCardListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        return binding.root
    }

}