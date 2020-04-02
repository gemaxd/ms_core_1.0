package com.mobilesales.mobilesalescore.ui.gallery

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilesales.mobilesalescore.R

class CatalogoViewModel(ctx: Context) : ViewModel() {
    var context : Context = ctx

    private val _text = MutableLiveData<String>().apply {
        value = "Catalogo"
    }
    val text: LiveData<String> = _text


    private val _title = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_catalogo)
    }
    val textTitle: LiveData<String> = _title


    private val _subtitle = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_catalogo_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle
}