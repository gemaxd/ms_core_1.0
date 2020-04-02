package com.mobilesales.mobilesalescore.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.ui.home.adapters.CarouselAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        homeViewModel = ViewModelProviders.of(this, HomeViewModelFactory(context!!)).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val title: TextView     = activity!!.main_toolbar_label
        val subTitle: TextView  = activity!!.main_toolbar_sublabel
        var tabDots: TabLayout = root.tabDots

        var mViewPager = root.home_pager
        val mResources = intArrayOf(
            R.drawable.image_01,
            R.drawable.image_02
        )
        tabDots.setupWithViewPager(mViewPager, true)

        val mCustomPagerAdapter = CarouselAdapter(context!!, mResources)
        mViewPager.setAdapter(mCustomPagerAdapter)
        homeViewModel.textTitle.observe(this@HomeFragment, Observer {
            title.text = it
        })

        homeViewModel.textSubtitle.observe(this@HomeFragment, Observer {
            subTitle.text = it
        })

        return root
    }
}