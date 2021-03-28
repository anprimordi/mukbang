package com.makaryostudio.mukbang.ui.materials.prism

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.PrismQuizFragmentBinding
import com.makaryostudio.mukbang.utils.DragShadowBuilder

class PrismQuizFragment : Fragment() {

    private lateinit var binding: PrismQuizFragmentBinding
    private lateinit var viewModel: PrismQuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        binding = DataBindingUtil.inflate(inflater, R.layout.prism_quiz_fragment, container, false)
        binding = PrismQuizFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(PrismQuizViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onDragAndDrop(binding.textAnswerOne, binding.textAnswerOne)
        onDragAndDrop(binding.textAnswerTwo, binding.textAnswerOne)
        onDragAndDrop(binding.textAnswerThree, binding.textAnswerOne)
        onDragAndDrop(binding.textAnswerFour, binding.textAnswerOne)

        onDragAndDrop(binding.textAnswerOne, binding.textAnswerTwo)
        onDragAndDrop(binding.textAnswerTwo, binding.textAnswerTwo)
        onDragAndDrop(binding.textAnswerThree, binding.textAnswerTwo)
        onDragAndDrop(binding.textAnswerFour, binding.textAnswerTwo)

        onDragAndDrop(binding.textAnswerOne, binding.textAnswerThree)
        onDragAndDrop(binding.textAnswerTwo, binding.textAnswerThree)
        onDragAndDrop(binding.textAnswerThree, binding.textAnswerThree)
        onDragAndDrop(binding.textAnswerFour, binding.textAnswerThree)

        onDragAndDrop(binding.textAnswerOne, binding.textAnswerFour)
        onDragAndDrop(binding.textAnswerTwo, binding.textAnswerFour)
        onDragAndDrop(binding.textAnswerThree, binding.textAnswerFour)
        onDragAndDrop(binding.textAnswerFour, binding.textAnswerFour)

        binding.buttonNext.setOnClickListener {

            viewModel.questionOne.observe(viewLifecycleOwner, {
                if (it == "") {
                    binding.textQuestionOne.apply {
                        error = getString(R.string.error_must_be_answered)
                        requestFocus()
                    }
                }
            })
            viewModel.questionTwo.observe(viewLifecycleOwner, {
                if (it == "") {
                    binding.textQuestionTwo.apply {
                        error = getString(R.string.error_must_be_answered)
                        requestFocus()
                    }
                }
            })
            viewModel.questionThree.observe(viewLifecycleOwner, {
                if (it == "") {
                    binding.textQuestionThree.apply {
                        error = getString(R.string.error_must_be_answered)
                        requestFocus()
                    }
                }
            })
            viewModel.questionFour.observe(viewLifecycleOwner, {
                if (it == "") {
                    binding.textQuestionFour.apply {
                        error = getString(R.string.error_must_be_answered)
                        requestFocus()
                    }
                }
            })

            val answerA = binding.textQuestionOne.text.toString()
            val answerB = binding.textQuestionTwo.text.toString()
            val answerC = binding.textQuestionThree.text.toString()
            val answerD = binding.textQuestionFour.text.toString()

            checkKey(answerA, answerB, answerC, answerD)

            viewModel.score.observe(viewLifecycleOwner, {
                Log.e("TEST", "PRISM QUIZ SCORE: $it")
                when (it) {
                    4 -> findNavController().navigate(R.id.action_prismQuizFragment_to_prismSecondFragment)
                    else -> Toast.makeText(
                        requireContext(),
                        getString(R.string.error_incorrect_answer),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
    }

    private fun checkKey(
        keyCheckOne: String,
        keyCheckTwo: String,
        keyCheckThree: String,
        keyCheckFour: String
    ) {
        val keyOne = "Prisma segi delapan"
        val keyTwo = "Prisma segi lima"
        val keyThree = "Prisma segi empat"
        val keyFour = "Prisma segi tiga"
        if (keyCheckOne == keyOne) {
            viewModel.addScore()
        }
        if (keyCheckTwo == keyTwo) {
            viewModel.addScore()
        }
        if (keyCheckThree == keyThree) {
            viewModel.addScore()
        }
        if (keyCheckFour == keyFour) {
            viewModel.addScore()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun onDragAndDrop(from: TextView, to: TextView) {
        from.tag = from.text

        from.setOnClickListener { view ->
            (view as TextView).tag = view.text
        }

        var then = 0L
        from.setOnTouchListener { view: View, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                then = System.currentTimeMillis()
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                System.currentTimeMillis() - then
            }
            val item = ClipData.Item(view.tag as? CharSequence)

            val dragData = ClipData(
                view.tag as CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            val myShadow = DragShadowBuilder(view)

            view.startDragAndDrop(dragData, myShadow, null, 0)

//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                view.startDragAndDrop(dragData, myShadow, null, 0)
//            } else {
//                view.startDrag(dragData, myShadow, null, 0)
//            }
        }

        when (to.id) {
            binding.textQuestionOne.id -> to.setOnDragListener(dragListenA)
            binding.textQuestionTwo.id -> to.setOnDragListener(dragListenB)
            binding.textQuestionThree.id -> to.setOnDragListener(dragListenC)
            binding.textQuestionFour.id -> to.setOnDragListener(dragListenD)
        }
    }

    private val dragListenA = View.OnDragListener { view, event ->
        val receiverView = binding.textQuestionOne
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                if (event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    receiverView.setBackgroundColor(Color.CYAN)
                    receiverView.text = viewModel.questionOneDrop.value
                    view.invalidate()
                    true
                } else {
                    false
                }
            }

            DragEvent.ACTION_DRAG_ENTERED -> {
                receiverView.setBackgroundColor(Color.GREEN)
                receiverView.text = viewModel.questionOneDrop.value
                view.invalidate()
                true
            }

            DragEvent.ACTION_DRAG_LOCATION ->
                true

            DragEvent.ACTION_DRAG_EXITED -> {
                receiverView.setBackgroundColor(Color.YELLOW)
                receiverView.text = viewModel.questionOneDrop.value
                view.invalidate()
                true
            }

            DragEvent.ACTION_DROP -> {
                val item: ClipData.Item = event.clipData.getItemAt(0)
                val dragData = item.text
                receiverView.text = "$dragData"
                viewModel.questionOneDrop.value = receiverView.text.toString()
                view.invalidate()
                true
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                receiverView.setBackgroundColor(Color.WHITE)
                view.invalidate()

                when (event.result) {
                    true -> {
                        // drop was handled
                        receiverView.setBackgroundColor(Color.WHITE)
                        receiverView.background =
                            getDrawable(requireContext(), R.drawable.container_drop_key)
                    }
                    else -> {
                        // drop didn't work
                        receiverView.text = viewModel.answerOne.value
                        receiverView.setBackgroundColor(Color.RED)
                    }
                }

                // returns true; the value is ignored.
                true
            }

            else -> {
                // An unknown action type was received.
                false
            }
        }
    }
    private val dragListenB = View.OnDragListener { view, event ->
        val receiverView = binding.textQuestionTwo
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                if (event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    receiverView.setBackgroundColor(Color.CYAN)
                    receiverView.text = viewModel.questionTwoDrop.value
                    view.invalidate()
                    true
                } else {
                    false
                }
            }

            DragEvent.ACTION_DRAG_ENTERED -> {
                receiverView.setBackgroundColor(Color.GREEN)
                receiverView.text = viewModel.questionTwoDrop.value
                view.invalidate()
                true
            }

            DragEvent.ACTION_DRAG_LOCATION ->
                true

            DragEvent.ACTION_DRAG_EXITED -> {
                receiverView.setBackgroundColor(Color.YELLOW)
                receiverView.text = viewModel.questionTwoDrop.value
                view.invalidate()
                true
            }

            DragEvent.ACTION_DROP -> {
                val item: ClipData.Item = event.clipData.getItemAt(0)
                val dragData = item.text
                receiverView.text = "$dragData"
                viewModel.questionTwoDrop.value = receiverView.text.toString()
                view.invalidate()
                true
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                receiverView.setBackgroundColor(Color.WHITE)
                view.invalidate()

                when (event.result) {
                    true -> {
                        // drop was handled
                        receiverView.setBackgroundColor(Color.WHITE)
                        receiverView.background =
                            getDrawable(requireContext(), R.drawable.container_drop_key)
                    }
                    else -> {
                        // drop didn't work
                        receiverView.text = viewModel.questionTwoDrop.value
                        receiverView.setBackgroundColor(Color.RED)
                    }
                }

                // returns true; the value is ignored.
                true
            }

            else -> {
                // An unknown action type was received.
                false
            }
        }
    }
    private val dragListenC = View.OnDragListener { view, event ->
        val receiverView = binding.textQuestionThree
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                if (event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    receiverView.setBackgroundColor(Color.CYAN)
                    receiverView.text = viewModel.questionThreeDrop.value
                    view.invalidate()
                    true
                } else {
                    false
                }
            }

            DragEvent.ACTION_DRAG_ENTERED -> {
                receiverView.setBackgroundColor(Color.GREEN)
                receiverView.text = viewModel.questionThreeDrop.value
                view.invalidate()
                true
            }

            DragEvent.ACTION_DRAG_LOCATION ->
                true

            DragEvent.ACTION_DRAG_EXITED -> {
                receiverView.setBackgroundColor(Color.YELLOW)
                receiverView.text = viewModel.questionThreeDrop.value
                view.invalidate()
                true
            }

            DragEvent.ACTION_DROP -> {
                val item: ClipData.Item = event.clipData.getItemAt(0)
                val dragData = item.text
                receiverView.text = "$dragData"
                viewModel.questionThreeDrop.value = receiverView.text.toString()
                view.invalidate()
                true
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                receiverView.setBackgroundColor(Color.WHITE)
                view.invalidate()

                when (event.result) {
                    true -> {
                        // drop was handled
                        receiverView.setBackgroundColor(Color.WHITE)
                        receiverView.background =
                            getDrawable(requireContext(), R.drawable.container_drop_key)
                    }
                    else -> {
                        // drop didn't work
                        receiverView.text = viewModel.questionThreeDrop.value
                        receiverView.setBackgroundColor(Color.RED)
                    }
                }

                // returns true; the value is ignored.
                true
            }

            else -> {
                // An unknown action type was received.
                false
            }
        }
    }
    private val dragListenD = View.OnDragListener { view, event ->
        val receiverView = binding.textQuestionFour
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                if (event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    receiverView.setBackgroundColor(Color.CYAN)
                    receiverView.text = viewModel.questionFourDrop.value
                    view.invalidate()
                    true
                } else {
                    false
                }
            }

            DragEvent.ACTION_DRAG_ENTERED -> {
                receiverView.setBackgroundColor(Color.GREEN)
                receiverView.text = viewModel.questionFourDrop.value
                view.invalidate()
                true
            }

            DragEvent.ACTION_DRAG_LOCATION ->
                true

            DragEvent.ACTION_DRAG_EXITED -> {
                receiverView.setBackgroundColor(Color.YELLOW)
                receiverView.text = viewModel.questionFourDrop.value
                view.invalidate()
                true
            }

            DragEvent.ACTION_DROP -> {
                val item: ClipData.Item = event.clipData.getItemAt(0)
                val dragData = item.text
                receiverView.text = "$dragData"
                viewModel.questionFourDrop.value = receiverView.text.toString()
                view.invalidate()
                true
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                receiverView.setBackgroundColor(Color.WHITE)
                view.invalidate()

                when (event.result) {
                    true -> {
                        receiverView.setBackgroundColor(Color.WHITE)
                        receiverView.background =
                            getDrawable(requireContext(), R.drawable.container_drop_key)
                    }
                    // drop was handled

                    else -> {
                        // drop didn't work
                        receiverView.text = viewModel.questionFourDrop.value
                        receiverView.setBackgroundColor(Color.RED)
                    }
                }

                // returns true; the value is ignored.
                true
            }

            else -> {
                // An unknown action type was received.
                false
            }
        }
    }
}