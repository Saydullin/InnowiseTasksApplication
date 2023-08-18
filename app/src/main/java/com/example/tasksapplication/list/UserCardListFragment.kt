package com.example.tasksapplication.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasksapplication.databinding.FragmentUserCardListBinding
import com.example.tasksapplication.list.adapter.UserCardListAdapter
import com.example.tasksapplication.list.utils.UserGenerator

class UserCardListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUserCardListBinding.inflate(layoutInflater)

        val users = UserGenerator.generateRandomUsers(30)
        binding.userCardListRecyclerView.adapter = UserCardListAdapter(requireContext(), users)
        binding.userCardListRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

}