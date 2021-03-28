package com.makaryostudio.mukbang.ui.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.LandingFragmentBinding

class LandingFragment : Fragment() {

    private lateinit var binding: LandingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.landing_fragment, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonStart.setOnClickListener {
            findNavController().navigate(R.id.action_landingFragment_to_loginFragment)
        }

        binding.buttonDevInfo.setOnClickListener {
            findNavController().navigate(R.id.action_landingFragment_to_developerFragment)
        }
    }
}