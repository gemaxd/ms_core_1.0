package com.mobilesales.mobilesalescore.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.ui.home.adapters.BannersAdapter

class HomeViewModel(context : Context) : ViewModel() {
    private val recycler_main = MutableLiveData<BannersAdapter>().apply {
        value = BannersAdapter()
    }
    val recycler: LiveData<BannersAdapter> = recycler_main

    private val _title = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_home)
    }
    val textTitle: LiveData<String> = _title


    private val _subtitle = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_home_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle

}