package com.makaryostudio.mukbang.ui.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.makaryostudio.mukbang.databinding.ScoreFragmentBinding
import com.makaryostudio.mukbang.model.section.SectionData

class ScoreFragment : Fragment() {

    //    private val scoreCube: String
//    private lateinit var scorePrism: String
//    private lateinit var scorePyramid: String
//    private lateinit var scoreFinal: String
    private lateinit var binding: ScoreFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScoreFragmentBinding.inflate(inflater)

        return binding.root
    }

    private fun getScore(code: Int): String = SectionData.listSection[code].score.toString()

}