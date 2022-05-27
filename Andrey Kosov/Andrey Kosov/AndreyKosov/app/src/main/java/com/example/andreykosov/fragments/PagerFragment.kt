package com.example.andreykosov.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.andreykosov.R
import com.example.andreykosov.databinding.FragmentPagerBinding

class PagerFragment(private val position: Int) : Fragment() {
    lateinit var binding: FragmentPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        when (position) {
            0 -> binding.textViewPagerFragment.text = getString(R.string.task_work)
            1 -> binding.textViewPagerFragment.text = getString(R.string.task_entertainment)
            2 -> binding.textViewPagerFragment.text = getString(R.string.task_study)
        }
        return binding.root
    }
}
