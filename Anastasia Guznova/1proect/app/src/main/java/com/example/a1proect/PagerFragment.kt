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
            0 -> binding.pagerFragmentText.text = getString(R.string.fragment_task_pager_work)
            1 ->
                binding.pagerFragmentText.text =
                    getString(R.string.fragment_task_pager_entertainment)
            2 -> binding.pagerFragmentText.text = getString(R.string.fragment_task_pager_study)
        }
        return binding.root
    }
}
