package com.mobilesales.mobilesalescore.modulos.cliente.views.fragments.cliente_main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilesales.mobilesalescore.modulos.cliente.interfaces.ClienteClickListener


class ClientesViewModelFactory(private val context : Context, private val listener : ClienteClickListener) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ClientesViewModel(
            context,
            listener
        ) as T
    }

}

