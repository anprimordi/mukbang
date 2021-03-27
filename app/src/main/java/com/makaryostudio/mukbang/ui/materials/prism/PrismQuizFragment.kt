package com.makaryostudio.mukbang.ui.materials.prism

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.makaryostudio.mukbang.R

class PrismQuizFragment : Fragment() {

    // TODO: 28/03/2021 add prism quiz 
    private lateinit var viewModel: PrismQuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(PrismQuizViewModel::class.java)
        return inflater.inflate(R.layout.prism_quiz_fragment, container, false)
    }

}