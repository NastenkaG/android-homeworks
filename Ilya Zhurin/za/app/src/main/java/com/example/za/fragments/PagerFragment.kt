package com.example.za.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.za.R
import com.example.za.databinding.FragmentPagerBinding

class PagerFragment(private val position: Int) : Fragment() {
    lateinit var binding: FragmentPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        when (position) {
            0 -> binding.textViewFragmentPagerText.text = getString(R.string.pager_work)
            1 -> binding.textViewFragmentPagerText.text = getString(R.string.pager_entertainment)
            2 -> binding.textViewFragmentPagerText.text = getString(R.string.pager_study)
        }
        return binding.root
    }
}
