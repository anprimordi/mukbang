package com.makaryostudio.mukbang.ui.materials.prism

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.google.android.material.appbar.MaterialToolbar
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.MaterialsFragmentBinding
import com.makaryostudio.mukbang.model.materials.MaterialsData

class PrismSecondFragment : Fragment() {

    private lateinit var binding: MaterialsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.materials_fragment, container, false)

        setupToolbar(binding.toolbar)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.title = "Prisma"

        binding.pdfMaterials.fromAsset("mat_prism_2.pdf")
            .enableSwipe(true)
            .enableDoubletap(true)
            .swipeHorizontal(false)
            .pageFitPolicy(FitPolicy.BOTH)
            .spacing(0)
            .load()
    }

    private fun setupToolbar(toolbar: MaterialToolbar) {
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        toolbar.setupWithNavController(findNavController(), appBarConfiguration)
        NavigationUI.setupWithNavController(toolbar, findNavController(), appBarConfiguration)

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_complete -> completeMaterials()
                else -> {
                    false
                }
            }
        }
    }

    private fun completeMaterials(): Boolean {
        MaterialsData.listMaterials[1].completed = true
        findNavController().navigate(R.id.action_prismSecondFragment_to_homeFragment)
        return true
    }
}