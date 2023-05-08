package com.example.laboratorio05.ui.data.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovielModel
import com.example.laboratorio05.databinding.FragmentBillboardBinding
import com.example.laboratorio05.ui.data.movie.MovieViewModel
import com.example.laboratorio05.ui.data.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.laboratorio05.ui.data.movie.billboard.recyclerview.MovieRecyclerViewHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {
    private lateinit var binding: FragmentBillboardBinding

    private lateinit var adapter: MovieRecyclerViewAdapter
    private val movieViewModel: MovieViewModel by activityViewModels { MovieViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
    }

    private fun showSelectedItem(movie: MovielModel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }

    private fun displayMovies() {
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerViewWisget.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapter { selectedMovie -> showSelectedItem(selectedMovie) }
        binding.recyclerViewWisget.adapter = adapter
        displayMovies()
    }

    fun createNewMovie() {
        movieViewModel.clearData()
        findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
    }
}