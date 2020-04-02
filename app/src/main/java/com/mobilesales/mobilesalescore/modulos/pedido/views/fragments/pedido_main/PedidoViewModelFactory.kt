package com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_main

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilesales.mobilesalescore.ui.gallery.PedidoViewModel

class PedidoViewModelFactory(private val context : Context) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PedidoViewModel(context) as T
    }
}