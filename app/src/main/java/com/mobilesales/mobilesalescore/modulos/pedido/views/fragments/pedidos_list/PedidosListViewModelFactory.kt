package com.mobilesales.mobilesalescore.ui.pedidos

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.PedidoClickListener
import com.mobilesales.mobilesalescore.ui.gallery.PedidosListViewModel

class PedidosListViewModelFactory(private val context : Context, private val listener : PedidoClickListener) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PedidosListViewModel(context, listener) as T
    }
}