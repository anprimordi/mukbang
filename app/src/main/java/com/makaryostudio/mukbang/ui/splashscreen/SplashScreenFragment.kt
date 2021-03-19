package com.makaryostudio.mukbang.ui.splashscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.SplashScreenFragmentBinding

class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: SplashScreenFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.splash_screen_fragment, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_landingFragment)
        }, 1000)

        return binding.root
    }
}