package com.example.tasksapplication.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasksapplication.R
import com.example.tasksapplication.databinding.FragmentUserListBinding
import com.example.tasksapplication.list.adapter.UserListAdapter
import com.example.tasksapplication.list.utils.UserGenerator

class UserListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUserListBinding.inflate(layoutInflater)

        val users = UserGenerator.generateRandomUsers(30)
        binding.userListRecyclerView.adapter = UserListAdapter(requireContext(), users)
        binding.userListRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

}