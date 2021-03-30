package com.makaryostudio.mukbang.ui.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.makaryostudio.mukbang.R

class ScoreFragment : Fragment() {

    companion object {
        fun newInstance() = ScoreFragment()
    }

    private lateinit var viewModel: ScoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.score_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        // TODO: Use the ViewModel
    }

}