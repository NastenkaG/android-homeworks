package com.example.a1proect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a1proect.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private lateinit var preferenceManager: PreferenceManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        preferenceManager = PreferenceManager(context)
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val name = activity?.intent?.extras?.getString("Name")
        if (preferenceManager.readFromPreferenceEmail().isNotEmpty())
            binding.greetingHome.text = getString(R.string.home_greeting, preferenceManager.readFromPreferenceEmail())
        else
            binding.greetingHome.text = getString(R.string.home_greeting, name)

        return binding.root
    }
}
