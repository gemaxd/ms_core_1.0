package com.mobilesales.mobilesalescore.ui.titulos.detalhes

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.TitulosItemClickListener
import com.mobilesales.mobilesalescore.ui.gallery.TituloDetalhesViewModel
import com.mobilesales.mobilesalescore.ui.gallery.TitulosViewModel

class TituloDetalhesViewModelFactory(private val context : Context, private val listener : TitulosItemClickListener) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TituloDetalhesViewModel(context, listener) as T
    }
}