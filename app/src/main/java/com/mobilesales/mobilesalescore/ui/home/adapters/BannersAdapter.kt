package com.mobilesales.mobilesalescore.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilesales.mobilesalescore.R

class BannersAdapter : RecyclerView.Adapter<BannersViewHolder>() {

    override fun getItemCount(): Int {
        return 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannersViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellBanner = layoutInflater.inflate(R.layout.banner_row, parent , false)
        return BannersViewHolder(cellBanner)
    }

    override fun onBindViewHolder(holder: BannersViewHolder, position: Int) {

    }

}

class BannersViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView){

}