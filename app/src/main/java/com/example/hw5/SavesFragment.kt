package com.example.hw5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class SavesFragment(private var fragmentLikeListener: SavesAdapter.FragmentLikeListener) : Fragment() {

    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SavesAdapter
    private var newsList: MutableList<News> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater
            .inflate(R.layout.page, container, false) as ViewGroup
        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        newsList = ArrayList()
        adapter = SavesAdapter(
            newsList,
            fragmentLikeListener
        )
        recyclerView.adapter = adapter
        return rootView
    }

    fun addNews(news: News){
        this.newsList.add(news)
        adapter.notifyDataSetChanged()
    }
    fun removeNews(news: News){
        if (newsList.indexOf(news)==0){
            newsList.remove(news)
        } else {
            var n = newsList.indexOf(news)
            this.newsList.remove(news)
            adapter.notifyItemRemoved(n)
        }
    }
    fun removeLike(news: News){
        newsList.remove(news)
        adapter.notifyDataSetChanged()
    }
}