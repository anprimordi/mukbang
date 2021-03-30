package com.makaryostudio.mukbang.ui.finalquiz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.DialogQuizScoreBinding
import com.makaryostudio.mukbang.databinding.FinalQuizFragmentBinding
import com.makaryostudio.mukbang.model.section.Section
import com.makaryostudio.mukbang.model.section.SectionData
import com.makaryostudio.mukbang.utils.QuizCodes

class FinalQuizFragment : Fragment() {

    private lateinit var binding: FinalQuizFragmentBinding
    private lateinit var dialogQuizScoreBinding: DialogQuizScoreBinding
    private lateinit var viewModel: FinalQuizViewModel
    private lateinit var viewModelFactory: FinalQuizViewModelFactory
    private val args: FinalQuizFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.final_quiz_fragment, container, false)

        viewModelFactory = FinalQuizViewModelFactory(args.quizCode)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FinalQuizViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        setupToolbar(binding.toolbar, args.quizCode)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var choice: String

        viewModel.number.observe(viewLifecycleOwner, {
            val number = it + 1
            viewModel.totalQuestion.observe(viewLifecycleOwner, { total ->
                binding.textNumber.text =
                    getString(R.string.quiz_num, number.toString(), total.toString())
            })
        })

        viewModel.key.observe(viewLifecycleOwner, { key ->
            Log.e("TESTING", key)
            binding.rgAnswers.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    binding.radioAnswerA.id -> {
                        choice = binding.radioAnswerA.text.toString()
                        binding.buttonNextQuestion.setOnClickListener {
                            if (choice == "") {
                                Toast.makeText(
                                    requireContext(),
                                    "Harus dijawab ya!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                choice = if (key == "a") {
                                    viewModel.addScore()
                                    ""
                                } else {
                                    ""
                                }
                                viewModel.nextQuestion()
                                binding.rgAnswers.clearCheck()
                            }
                        }
                    }
                    binding.radioAnswerB.id -> {
                        choice = binding.radioAnswerB.text.toString()
                        binding.buttonNextQuestion.setOnClickListener {
                            if (choice == "") {
                                Toast.makeText(
                                    requireContext(),
                                    "Harus dijawab ya!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                choice = if (key == "b") {
                                    viewModel.addScore()
                                    ""
                                } else {
                                    ""
                                }
                                viewModel.nextQuestion()
                                binding.rgAnswers.clearCheck()
                            }
                        }
                    }
                    binding.radioAnswerC.id -> {
                        choice = binding.radioAnswerC.text.toString()
                        binding.buttonNextQuestion.setOnClickListener {
                            if (choice == "") {
                                Toast.makeText(
                                    requireContext(),
                                    "Harus dijawab ya!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                choice = if (key == "c") {
                                    viewModel.addScore()
                                    ""
                                } else {
                                    ""
                                }
                                viewModel.nextQuestion()
                                binding.rgAnswers.clearCheck()
                            }
                        }
                    }
                    binding.radioAnswerD.id -> {
                        choice = binding.radioAnswerD.text.toString()
                        binding.buttonNextQuestion.setOnClickListener {
                            if (choice == "") {
                                Toast.makeText(
                                    requireContext(),
                                    "Harus dijawab ya!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                choice = if (key == "d") {
                                    viewModel.addScore()
                                    ""
                                } else {
                                    ""
                                }
                                viewModel.nextQuestion()
                                binding.rgAnswers.clearCheck()
                            }
                        }
                    }
                }
            }
        })

        viewModel.eventQuestCompleted.observe(viewLifecycleOwner, {
            if (it) completeQuest()
        })

        when (args.quizCode) {
            3 -> when (viewModel.currentNumber + 1) {
                15 -> binding.imageQuestion.setImageResource(R.drawable.img_final_15)
                19 -> binding.imageQuestion.setImageResource(R.drawable.img_final_19)
            }
        }
    }

    private fun completeQuest() {
        showScoreDialog(
            viewModel.onQuestComplete(
                args.quizCode,
                viewModel.score.value!!.calculateScore(args.quizCode)
            )
        )
    }

    private fun showScoreDialog(section: Section) {
        val builder = MaterialAlertDialogBuilder(requireContext())

        dialogQuizScoreBinding = DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            R.layout.dialog_quiz_score,
            null,
            false
        )

        dialogQuizScoreBinding.textScore.text = section.score.toString()

        builder.setView(dialogQuizScoreBinding.root)

        builder.setTitle(section.sectionName)

        builder.setPositiveButton("kembali ke beranda") { dialog, _ ->
            dialog.dismiss()
//            findNavController().navigateUp()
            findNavController().navigate(R.id.action_finalQuizFragment_to_homeFragment)
        }

        val alert = builder.create()
        alert.show()
    }

    private fun Int.calculateScore(code: Int): Int {
        return when (code) {
            QuizCodes.CUBE -> this * 10
            QuizCodes.PRISM -> this * 20
            QuizCodes.PYRAMID -> this * 20
            QuizCodes.FINAL -> this * 5
            else -> 0
        }
    }

    private fun setupToolbar(toolbar: MaterialToolbar, code: Int) {
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        toolbar.setupWithNavController(findNavController(), appBarConfiguration)
        NavigationUI.setupWithNavController(toolbar, findNavController(), appBarConfiguration)
        toolbar.title = SectionData.listSection[code].sectionName
    }
}