package com.makaryostudio.mukbang.ui.developer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.DeveloperFragmentBinding

class DeveloperFragment : Fragment() {

    private lateinit var binding: DeveloperFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DeveloperFragmentBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonReference.setOnClickListener {
            findNavController().navigate(R.id.action_developerFragment_to_referenceFragment)
        }
    }
}