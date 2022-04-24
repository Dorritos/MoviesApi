package com.dorritos.moviesapi.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dorritos.moviesapi.R
import com.dorritos.moviesapi.ui.main.adapters.MoviesAdapter


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    val nestedScroll = view?.findViewById<NestedScrollView>(R.id.nestedScrollMovies)
    val progressBar = view?.findViewById<ProgressBar>(R.id.progressBarMovie)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerViewMovies)

        recycler.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getMovies().observe(viewLifecycleOwner, Observer { movies ->
            val moviesList = movies.results
            if (moviesList.isNotEmpty())
            {
                applyPagging()
                progressBar?.visibility = View.GONE
                val adapter = MoviesAdapter(moviesList)
                recycler.adapter = adapter
            }
        })
    }

    private fun applyPagging() {
        nestedScroll?.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, _, scrollY, _, _ ->
            if (v.getChildAt(0).bottom <= nestedScroll.height + scrollY) {
                progressBar?.visibility = View.VISIBLE
            }
        })
    }

}