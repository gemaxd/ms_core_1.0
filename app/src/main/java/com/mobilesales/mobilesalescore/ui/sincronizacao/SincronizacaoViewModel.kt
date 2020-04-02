package com.mobilesales.mobilesalescore.ui.gallery

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilesales.mobilesalescore.R

class SincronizacaoViewModel(ctx: Context) : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = ctx.getString(R.string.menu_sincronizacao)
    }
    val textTitle: LiveData<String> = _title

    private val _subtitle = MutableLiveData<String>().apply {
        value = ctx.getString(R.string.menu_sincronizacao_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle

}