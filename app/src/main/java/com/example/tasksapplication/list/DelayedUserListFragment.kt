package com.example.tasksapplication.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasksapplication.databinding.FragmentDelayedUserListBinding
import com.example.tasksapplication.list.adapter.UserListAdapter
import com.example.tasksapplication.list.utils.UserDataSource
import com.example.tasksapplication.list.utils.UserGenerator

class DelayedUserListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDelayedUserListBinding.inflate(layoutInflater)

        val users = UserGenerator.generateRandomUsers(30) as ArrayList
        val adapter = UserListAdapter(requireContext(), users)
        binding.usersListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.delayedListProgressBar.visibility = View.VISIBLE
        binding.emptyListText.visibility = View.GONE

        binding.usersListRecyclerView.postDelayed({
            binding.usersListRecyclerView.adapter = adapter
            binding.delayedListProgressBar.visibility = View.GONE
        }, 6000)

        binding.deleteButton.setOnClickListener {
            adapter.clear()
            binding.emptyListText.visibility = View.VISIBLE
        }

        binding.swipeRefresh.setOnRefreshListener {
            binding.emptyListText.visibility = View.GONE
            binding.usersListRecyclerView.postDelayed({
                val userDataSource = UserDataSource()
                adapter.update(userDataSource.getUsers())
                binding.swipeRefresh.isRefreshing = false
            }, 3000)
        }

        return binding.root
    }

}