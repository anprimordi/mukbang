package com.makaryostudio.mukbang.ui.finalquiz

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.makaryostudio.mukbang.R

class FinalQuizFragment : Fragment() {

    companion object {
        fun newInstance() = FinalQuizFragment()
    }

    private lateinit var viewModel: FinalQuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.final_quiz_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FinalQuizViewModel::class.java)
        // TODO: Use the ViewModel
    }

}