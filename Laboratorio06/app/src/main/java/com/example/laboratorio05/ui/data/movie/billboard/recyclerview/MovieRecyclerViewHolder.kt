package com.example.laboratorio05.ui.data.movie.billboard.recyclerview

import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.model.MovielModel
import com.example.laboratorio05.databinding.MovieItemBinding

class MovieRecyclerViewHolder(private val binding: MovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovielModel, clickListener: (MovielModel) -> Unit) {
        binding.titleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener{
            clickListener(movie)
        }
    }
}