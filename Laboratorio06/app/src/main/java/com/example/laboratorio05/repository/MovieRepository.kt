package com.example.laboratorio05.repository

import com.example.laboratorio05.data.model.MovielModel

class MovieRepository (private val movies: MutableList<MovielModel>){
    fun getMovies() = movies
    fun addMovies(movie: MovielModel) = movies.add(movie)
}