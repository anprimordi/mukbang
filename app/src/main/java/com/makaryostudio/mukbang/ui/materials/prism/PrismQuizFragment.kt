package com.makaryostudio.mukbang.ui.materials.prism

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.makaryostudio.mukbang.R

class PrismQuizFragment : Fragment() {

    companion object {
        fun newInstance() = PrismQuizFragment()
    }

    private lateinit var viewModel: PrismQuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.prism_quiz_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PrismQuizViewModel::class.java)
        // TODO: Use the ViewModel
    }

}