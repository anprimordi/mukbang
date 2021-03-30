package com.makaryostudio.mukbang.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.makaryostudio.mukbang.databinding.IntroFragmentBinding

class IntroFragment : Fragment() {

    private lateinit var binding: IntroFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = IntroFragmentBinding.inflate(inflater)

        setupToolbar(binding.toolbar)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pdfIntroduction.fromAsset("intro.pdf")
            .enableSwipe(true)
            .enableDoubletap(true)
            .swipeHorizontal(false)
            .pageFitPolicy(FitPolicy.BOTH)
            .spacing(0)
            .load()
    }

    private fun setupToolbar(toolbar: Toolbar) {
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        toolbar.setupWithNavController(findNavController(), appBarConfiguration)
        NavigationUI.setupWithNavController(toolbar, findNavController(), appBarConfiguration)
    }
}