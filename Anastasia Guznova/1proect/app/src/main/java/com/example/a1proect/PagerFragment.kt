package com.example.a1proect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a1proect.databinding.FragmentPagerBinding

class PagerFragment(private val position: Int) : Fragment() {
    lateinit var binding: FragmentPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        when (position) {
            0 -> TaskWorkFragment()
            1 -> TaskWorkFragment()
            2 -> TaskWorkFragment()
        }
        return binding.root
    }
}
