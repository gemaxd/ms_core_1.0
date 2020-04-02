package com.mobilesales.mobilesalescore.ui.gallery

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import com.mobilesales.mobilesalescore.modulos.cliente.interfaces.ClienteClickListener


class PedidoViewModel(ctx: Context) : ViewModel(), ClienteClickListener{
    val context = ctx
    lateinit var db : AppDatabase

    private val _title = MutableLiveData<String>().apply {
        value = ctx.getString(R.string.menu_pedidos)
    }
    val textTitle: LiveData<String> = _title

    private val _subtitle = MutableLiveData<String>().apply {
        value = ctx.getString(R.string.menu_pedidos_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle

    /**Seleção de cliente*/
    fun mostraDialogSelectCliente(){
    }

    override fun onClienteSelectOptions(cliente: Cliente) {
        Toast.makeText(context, "teste de clique "+cliente.nomCli, Toast.LENGTH_SHORT).show()
    }

    override fun onClienteClickOptions(view: View, position: Int) {
        Toast.makeText(context, "teste de clique "+position, Toast.LENGTH_SHORT).show()
    }

}