package com.dorritos.newsapi.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dorritos.newsapi.R
import com.dorritos.newsapi.ui.main.adapters.ArticleAdapter

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerViewArticles)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getArticles().observe(viewLifecycleOwner, Observer { articles ->
            val adapter = ArticleAdapter(articles.articles)
            recycler.adapter = adapter
        })
    }

}