package com.makaryostudio.mukbang.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.HomeFragmentBinding
import com.makaryostudio.mukbang.model.materials.MaterialsData
import com.makaryostudio.mukbang.model.quiz.Quiz
import com.makaryostudio.mukbang.model.quiz.QuizData

class HomeFragment : Fragment() {
    private lateinit var binding: HomeFragmentBinding
    private lateinit var materialsAdapter: MaterialsAdapter
    private lateinit var quizAdapter: QuizAdapter
    private lateinit var materialsList: ArrayList<com.makaryostudio.mukbang.model.materials.Materials>
    private lateinit var quizList: ArrayList<Quiz>
    private lateinit var materialsClickListener: MaterialsClickListener
    private lateinit var quizClickListener: QuizClickListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val materialHorizontalLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val quizHorizontalLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        materialsClickListener = object : MaterialsClickListener {
            override fun clickListener(code: Int) {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToMaterialsFragment(code)
                )
            }
        }

        quizClickListener = object : QuizClickListener {
            override fun clickListener(code: Int) {
                when (code) {
                    3 -> findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToFinalQuizFragment(code)
                    )
                    else -> findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToQuizFragment(code)
                    )
                }
            }
        }

        materialsList = MaterialsData.listMaterials
        materialsAdapter = MaterialsAdapter(requireContext(), materialsList, materialsClickListener)

        binding.rvMaterials.apply {
            layoutManager = materialHorizontalLayoutManager
            adapter = materialsAdapter
        }

        quizList = QuizData.listQuiz
        quizAdapter = QuizAdapter(requireContext(), quizList, quizClickListener)

        binding.rvQuiz.apply {
            layoutManager = quizHorizontalLayoutManager
            adapter = quizAdapter
        }

        binding.layoutIdentity.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_identityFragment)
        }

        binding.imageIntro.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_introFragment)
        }

        binding.textIntro.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_introFragment)
        }

        binding.imageManual.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_manualFragment)
        }

        binding.textManual.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_manualFragment)
        }

        binding.imageConcept.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_conceptMapFragment)
        }

        binding.textConcept.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_conceptMapFragment)
        }
    }
}