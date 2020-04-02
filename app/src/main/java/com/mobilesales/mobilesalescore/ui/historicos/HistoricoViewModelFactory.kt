package com.mobilesales.mobilesalescore.ui.historicos

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.HistoricotemClickListener
import com.mobilesales.mobilesalescore.ui.gallery.HistoricoViewModel

class HistoricoViewModelFactory(private val context : Context, private val listener : HistoricotemClickListener) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HistoricoViewModel(context, listener) as T
    }
}