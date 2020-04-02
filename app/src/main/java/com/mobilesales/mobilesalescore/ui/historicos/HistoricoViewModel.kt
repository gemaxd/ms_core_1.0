package com.mobilesales.mobilesalescore.ui.gallery

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.ui.clientes.adapters.HistoricosAdapter
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.HistoricotemClickListener

class HistoricoViewModel(ctx: Context, listener: HistoricotemClickListener) : ViewModel() {
    var context : Context = ctx

    private val recycler_main = MutableLiveData<HistoricosAdapter>().apply {
        value = HistoricosAdapter(ctx, listener)
    }
    val recycler: LiveData<HistoricosAdapter> = recycler_main


    private val _title = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_historicos)
    }
    val textTitle: LiveData<String> = _title


    private val _subtitle = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_historicos_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle
}