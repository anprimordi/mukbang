package com.makaryostudio.mukbang.ui.materials.prism

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.makaryostudio.mukbang.R

class PrismSecondFragment : Fragment() {

    companion object {
        fun newInstance() = PrismSecondFragment()
    }

    private lateinit var viewModel: PrismSecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.prism_second_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PrismSecondViewModel::class.java)
        // TODO: Use the ViewModel
    }

}