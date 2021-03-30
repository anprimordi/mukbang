package com.makaryostudio.mukbang.ui.materials

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.google.android.material.appbar.MaterialToolbar
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.MaterialsFragmentBinding

class MaterialsFragment : Fragment() {

    private lateinit var binding: MaterialsFragmentBinding
    private lateinit var viewModel: MaterialsViewModel
    private lateinit var viewModelFactory: MaterialsViewModelFactory
    private val args: MaterialsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.materials_fragment, container, false)
        viewModelFactory = MaterialsViewModelFactory(args.materialsCode)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MaterialsViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModelFactory = MaterialsViewModelFactory(args.materialsCode)

        setupToolbar(binding.toolbar, args.materialsCode)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MaterialsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.title.observe(viewLifecycleOwner) {
            binding.toolbar.title = it
        }

        viewModel.pdfSource.observe(viewLifecycleOwner) {
            Log.e("pdfsource", it)
            binding.pdfMaterials.fromAsset(it)
                .enableSwipe(true)
                .enableDoubletap(true)
                .swipeHorizontal(false)
                .pageFitPolicy(FitPolicy.BOTH)
                .spacing(0)
                .load()
        }
    }

    private fun completeMaterials(code: Int): Boolean {
        when (code) {
            1 -> findNavController().navigate(R.id.action_materialsFragment_to_prismQuizFragment)
            else -> {
                viewModel.completeMaterials(code)
                findNavController().navigate(R.id.action_materialsFragment_to_homeFragment)
            }
        }
        return true
    }

    private fun setupToolbar(toolbar: MaterialToolbar, code: Int) {
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        toolbar.setupWithNavController(findNavController(), appBarConfiguration)
        NavigationUI.setupWithNavController(toolbar, findNavController(), appBarConfiguration)

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_complete -> completeMaterials(code)
                else -> {
                    false
                }
            }
        }
    }
}