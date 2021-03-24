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
import com.makaryostudio.mukbang.model.materials.Materials
import com.makaryostudio.mukbang.model.materials.MaterialsData
import com.makaryostudio.mukbang.model.quiz.Quiz

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var materialsAdapter: MaterialsAdapter
    private lateinit var quizAdapter: QuizAdapter
    private lateinit var materialsList: ArrayList<Materials>
    private lateinit var quizList: ArrayList<Quiz>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val horizontalLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        materialsList = MaterialsData.listMaterials
        materialsAdapter = MaterialsAdapter(requireContext(), materialsList)

        binding.rvMaterials.apply {
            layoutManager = horizontalLayoutManager
            adapter = materialsAdapter
        }


        binding.layoutIdentity.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_identityFragment)
        }

    }
}