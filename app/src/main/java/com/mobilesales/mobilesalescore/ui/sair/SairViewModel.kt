package com.mobilesales.mobilesalescore.ui.gallery

import android.content.Context
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilesales.mobilesalescore.R
import kotlinx.android.synthetic.main.app_bar_main.*

class SairViewModel(ctx: Context) : ViewModel() {
    var context : Context = ctx

    private val _text = MutableLiveData<String>().apply {
        value = "Sair"
    }
    val text: LiveData<String> = _text


    private val _title = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_sair)
    }
    val textTitle: LiveData<String> = _title


    private val _subtitle = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_sair_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle


}