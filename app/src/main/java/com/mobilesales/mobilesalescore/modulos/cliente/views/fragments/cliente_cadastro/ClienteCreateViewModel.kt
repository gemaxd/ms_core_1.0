package com.mobilesales.mobilesalescore.modulos.cliente.views.fragments.cliente_cadastro

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.user.ClienteBase

class ClienteCreateViewModel(ctx : Context) : ViewModel() {

    var context: Context = ctx
    var clienteBases: List<ClienteBase> = ArrayList()

    /**Observer da descrição de titulo*/
    private val _title = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_clientes_create)
    }
    val textTitle: LiveData<String> = _title

    /**Observer da descrição de subtitulo*/
    private val _subtitle = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_clientes_create_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle
}