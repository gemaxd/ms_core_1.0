package com.mobilesales.mobilesalescore.ui.gallery

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.TitulosItemClickListener

class TituloDetalhesViewModel(ctx: Context, listener : TitulosItemClickListener) : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = ctx.getString(R.string.menu_titulos)
    }
    val textTitle: LiveData<String> = _title

    private val _subtitle = MutableLiveData<String>().apply {
        value = ctx.getString(R.string.menu_titulos_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle
}