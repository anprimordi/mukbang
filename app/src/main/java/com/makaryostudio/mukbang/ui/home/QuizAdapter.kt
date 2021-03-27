package com.makaryostudio.mukbang.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.mukbang.databinding.ItemQuizBinding
import com.makaryostudio.mukbang.model.quiz.Quiz
import com.makaryostudio.mukbang.ui.home.QuizAdapter.ViewHolder

class QuizAdapter(
    private val context: Context,
    private val list: ArrayList<Quiz>,
    private val quizClickListener: QuizClickListener
) : RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(private val itemQuizBinding: ItemQuizBinding) :
        RecyclerView.ViewHolder(itemQuizBinding.root) {
        fun bindView(quiz: Quiz, quizClickListener: QuizClickListener, position: Int) {
            itemQuizBinding.imageItemThumbnail.setImageResource(quiz.thumbnail)
            itemQuizBinding.imageItemTitle.text = quiz.title
            itemQuizBinding.imageItemBody.text =
                when (quiz.completed) {
                    false -> "Belum selesai"
                    true -> "Selesai"
                }

            itemQuizBinding.cardItemQuiz.setOnClickListener {
                quizClickListener.clickListener(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemQuizBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quiz = list[position]
        holder.bindView(quiz, quizClickListener, position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}


