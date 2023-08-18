package com.example.tasksapplication.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tasksapplication.R
import com.example.tasksapplication.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userListFragment = UserListFragment()
        openFragment(userListFragment)

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    openFragment(userListFragment)
                    true
                }
                R.id.action_search -> {
                    val userCardListFragment = UserCardListFragment()
                    openFragment(userCardListFragment)
                    true
                }
                R.id.action_notifications -> {
                    val cardListFragment = CardListFragment()
                    openFragment(cardListFragment)
                    true
                }
                R.id.action_profile -> {
                    // Обработка нажатия на элемент "Profile"
                    true
                }
                R.id.action_settings -> {
                    // Обработка нажатия на элемент "Settings"
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}