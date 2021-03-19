package com.makaryostudio.mukbang.ui.materials

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.makaryostudio.mukbang.R

class MaterialsFragment : Fragment() {

    companion object {
        fun newInstance() = MaterialsFragment()
    }

    private lateinit var viewModel: MaterialsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.materials_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MaterialsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}