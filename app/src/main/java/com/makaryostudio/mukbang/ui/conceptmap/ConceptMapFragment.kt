package com.makaryostudio.mukbang.ui.conceptmap

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.ConceptMapFragmentBinding

class ConceptMapFragment : Fragment() {

    private lateinit var binding: ConceptMapFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.concept_map_fragment, container, false)

        setupToolbar(binding.toolbar)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pdfViewConceptMap.fromAsset("concept_map.pdf")
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