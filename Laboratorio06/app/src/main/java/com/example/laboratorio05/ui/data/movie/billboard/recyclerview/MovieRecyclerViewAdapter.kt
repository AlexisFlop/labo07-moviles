package com.example.laboratorio05.ui.data.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.model.MovielModel
import com.example.laboratorio05.databinding.MovieItemBinding

class MovieRecyclerViewAdapter(private val clicListener: (MovielModel) -> Unit) :
    RecyclerView.Adapter<MovieRecyclerViewHolder>() {
    private val movies = ArrayList<MovielModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clicListener)
    }

    fun setData(movieList: List<MovielModel>){
        movies.clear()
        movies.addAll(movieList)
    }

}