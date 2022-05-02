package com.example.za.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.za.R
import com.example.za.adapters.ViewPagerAdapter
import com.example.za.databinding.FragmentTasksBinding
import com.google.android.material.tabs.TabLayoutMediator

class TasksFragment : Fragment() {
    lateinit var binding: FragmentTasksBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        binding.ViewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.TabLayout, binding.ViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.pager_work)
                1 -> getString(R.string.pager_entertainment)
                2 -> getString(R.string.pager_study)
                else -> null
            }
        }.attach()
        return binding.root
    }
}
