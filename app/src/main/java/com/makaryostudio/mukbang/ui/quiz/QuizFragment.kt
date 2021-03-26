package com.makaryostudio.mukbang.ui.quiz

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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.DialogQuizScoreBinding
import com.makaryostudio.mukbang.databinding.QuizFragmentBinding
import com.makaryostudio.mukbang.model.section.Section
import com.makaryostudio.mukbang.utils.QuizCodes

class QuizFragment : Fragment() {

    private lateinit var binding: QuizFragmentBinding
    private lateinit var dialogQuizScoreBinding: DialogQuizScoreBinding
    private lateinit var viewModel: QuizViewModel
    private lateinit var viewModelFactory: QuizViewModelFactory
    private val args: QuizFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.quiz_fragment, container, false)

        viewModelFactory = QuizViewModelFactory(args.quizCode)
        viewModel = ViewModelProvider(this, viewModelFactory).get(QuizViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var choice: String

        viewModel.number.observe(viewLifecycleOwner, { number ->
            viewModel.totalQuest.observe(viewLifecycleOwner, { total ->
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
                        binding.buttonShowAnswer.setOnClickListener {
                            if (choice == "") {
                                Toast.makeText(
                                    requireContext(),
                                    "Harus dijawab ya!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                binding.layoutExplanation.visibility = View.VISIBLE
                                choice = if (key == "a") {
                                    viewModel.addScore()
                                    ""
                                } else {
                                    ""
                                }
                            }
                        }
                    }
                    binding.radioAnswerB.id -> {
                        choice = binding.radioAnswerB.text.toString()
                        binding.buttonShowAnswer.setOnClickListener {
                            if (choice == "") {
                                Toast.makeText(
                                    requireContext(),
                                    "Harus dijawab ya!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                binding.layoutExplanation.visibility = View.VISIBLE
                                choice = if (key == "b") {
                                    viewModel.addScore()
                                    ""
                                } else {
                                    ""
                                }
                            }
                        }
                    }
                    binding.radioAnswerC.id -> {
                        choice = binding.radioAnswerC.text.toString()
                        binding.buttonShowAnswer.setOnClickListener {
                            if (choice == "") {
                                Toast.makeText(
                                    requireContext(),
                                    "Harus dijawab ya!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                binding.layoutExplanation.visibility = View.VISIBLE
                                choice = if (key == "c") {
                                    viewModel.addScore()
                                    ""
                                } else {
                                    ""
                                }
                            }
                        }
                    }
                    binding.radioAnswerD.id -> {
                        choice = binding.radioAnswerD.text.toString()
                        binding.buttonShowAnswer.setOnClickListener {
                            if (choice == "") {
                                Toast.makeText(
                                    requireContext(),
                                    "Harus dijawab ya!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                binding.layoutExplanation.visibility = View.VISIBLE
                                choice = if (key == "d") {
                                    viewModel.addScore()
                                    ""
                                } else {
                                    ""
                                }
                            }
                        }
                    }
                }
            }
        })

        viewModel.explanation.observe(viewLifecycleOwner, {
            binding.textExplanationBody.text = it
        })

        viewModel.key.observe(viewLifecycleOwner, {
            binding.textExplanationKey.text = getString(R.string.quiz_explanation_key, it)
        })

        viewModel.eventQuestCompleted.observe(viewLifecycleOwner, {
            if (it) completeQuest()
        })

        when (args.quizCode) {
            1 -> when (viewModel.currentNumber + 1) {
                2 -> binding.imageQuestion.setImageResource(R.drawable.img_prism_1)
                3 -> binding.imageQuestion.setImageResource(R.drawable.img_prism_2)
            }
            2 -> when (viewModel.currentNumber + 1) {
                1 -> binding.imageExplanation.setImageResource(R.drawable.img_pyramid_1)
                2 -> binding.imageExplanation.setImageResource(R.drawable.img_pyramid_2)
                3 -> binding.imageExplanation.setImageResource(R.drawable.img_pyramid_3)
                4 -> binding.imageQuestion.setImageResource(R.drawable.img_pyramid_4)
                5 -> binding.imageQuestion.setImageResource(R.drawable.img_pyramid_5)
            }
        }

        binding.buttonNextQuestion.setOnClickListener {
            viewModel.nextQuestion()
            binding.rgAnswers.clearCheck()
            binding.layoutExplanation.visibility = View.GONE
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
            findNavController().navigate(R.id.action_quizFragment_to_homeFragment)
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
}