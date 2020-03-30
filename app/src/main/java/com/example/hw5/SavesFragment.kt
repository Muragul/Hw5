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

class SavesFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private var newsList: List<News> = ArrayList()
    private var fragmentLikeListener: Adapter.FragmentLikeListener? = null
    private var fragmentButtonListener: Adapter.FragmentButtonListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater
            .inflate(R.layout.page, container, false) as ViewGroup
        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        fragmentLikeListener = object : Adapter.FragmentLikeListener {
            override fun removeItemLike(news: News) {
                (activity as MainActivity?)!!.removeItemLike(news!!)
            }
        }
        newsList = ArrayList<News>()
        adapter = Adapter(
            newsList,
            fragmentLikeListener as Adapter.FragmentLikeListener,
            fragmentButtonListener as Adapter.FragmentButtonListener
        )
        recyclerView.setAdapter(adapter)
        return rootView
    }
}