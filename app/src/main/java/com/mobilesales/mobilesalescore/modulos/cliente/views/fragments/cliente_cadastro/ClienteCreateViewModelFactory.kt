package com.mobilesales.mobilesalescore.modulos.cliente.views.fragments.cliente_cadastro

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ClienteCreateViewModelFactory(private val context : Context) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ClienteCreateViewModel(
            context
        ) as T
    }

}