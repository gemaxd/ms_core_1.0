package com.mobilesales.mobilesalescore.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.mobilesales.mobilesalescore.R

class CarouselAdapter(private val mContext: Context, private val mResources: IntArray) :
    PagerAdapter() {
    private val mLayoutInflater: LayoutInflater
    override fun getCount(): Int {
        return mResources.size
    }

    override fun isViewFromObject(
        view: View,
        `object`: Any
    ): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView =  mLayoutInflater.inflate(R.layout.carousel_item, container, false)
        val imageView =  itemView.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(mResources[position])
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as ConstraintLayout)
    }

    init {
        mLayoutInflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}