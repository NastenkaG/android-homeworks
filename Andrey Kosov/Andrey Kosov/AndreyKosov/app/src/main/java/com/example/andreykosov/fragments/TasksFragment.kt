package com.example.andreykosov.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.andreykosov.MyPagerAdapter
import com.example.andreykosov.R
import com.example.andreykosov.databinding.FragmentTasksBinding
import com.google.android.material.tabs.TabLayoutMediator

class TasksFragment : Fragment() {
    private lateinit var binding: FragmentTasksBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        binding.viewPager?.adapter = MyPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.task_work)
                1 -> getString(R.string.task_entertainment)
                2 -> getString(R.string.task_study)
                else -> null
            }
        }.attach()
        return binding.root
    }
}
