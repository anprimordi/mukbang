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
import androidx.navigation.fragment.navArgs
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.QuizFragmentBinding

class QuizFragment : Fragment() {

    private lateinit var binding: QuizFragmentBinding
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

        viewModel.key.observe(viewLifecycleOwner, { key ->
            Log.e("TESTING", key)
            binding.rgAnswers.setOnCheckedChangeListener { group, checkedId ->
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

        when (args.quizCode) {
            1 -> when (viewModel.currentNumber+1) {
                2 -> binding.imageQuestion.setImageResource(R.drawable.img_prism_1)
                3 -> binding.imageQuestion.setImageResource(R.drawable.img_prism_2)
            }
            2 -> when (viewModel.currentNumber+1) {
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

    private fun finishQuiz() {
        viewModel.onQuestComplete(args.quizCode, viewModel.score.value!!)
        // TODO: 26/03/2021 create score dialog 
    }
}