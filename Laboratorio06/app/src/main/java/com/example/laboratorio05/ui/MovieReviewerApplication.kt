package com.example.laboratorio05.ui

import android.app.Application
import com.example.laboratorio05.data.model.movies
import com.example.laboratorio05.repository.MovieRepository

class MovieReviewerApplication : Application(){
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies) }
}