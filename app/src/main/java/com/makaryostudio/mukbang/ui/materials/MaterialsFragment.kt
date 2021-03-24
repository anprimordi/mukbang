package com.makaryostudio.mukbang.ui.materials

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.MaterialsFragmentBinding

class MaterialsFragment : Fragment() {

    private lateinit var binding: MaterialsFragmentBinding
    private lateinit var viewModel: MaterialsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.materials_fragment, container, false)

        return inflater.inflate(R.layout.materials_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MaterialsViewModel::class.java)
    }

}