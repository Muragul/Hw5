package com.example.hw5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), SavesAdapter.FragmentLikeListener,
    Adapter.FragmentButtonListener, Adapter.FragmentLikeListener{
    private lateinit var pager: LockableViewPager
    private lateinit var pagerAdapter: PagerAdapter
    private var f1: Fragment = NewsFragment(this, this)
    private var f2: Fragment = SavesFragment(this)
    private var list: MutableList<Fragment> = ArrayList()
    lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bottomNavigationView = findViewById(R.id.bottom_navigation)
        list.add(f1)
        list.add(f2)
        pager = findViewById(R.id.pager)
        pager.setSwipable(false)
        pagerAdapter = SlidePagerAdapter(supportFragmentManager, list)
        pager.adapter = pagerAdapter

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    pager.setCurrentItem(0, false)
                    bottomNavigationView.menu.findItem(R.id.save)
                        .setIcon(R.drawable.ic_save)
                }
                R.id.save -> {
                    pager.setCurrentItem(1, false)
                    item.setIcon(R.drawable.ic_favorite)
                }
            }
            false
        }

    }

    override fun myClick(news: News, option: Int) {
        if (option==1){
            (f2 as SavesFragment).addNews(news)
        } else {
            (f2 as SavesFragment).removeNews(news)
        }

    }

    override fun removeItemLike(news: News) {
        (f1 as NewsFragment).removeLike(news)
        (f2 as SavesFragment).removeLike(news)
    }

}
