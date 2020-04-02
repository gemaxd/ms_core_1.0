package com.mobilesales.mobilesalescore.ui.gallery

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import com.mobilesales.mobilesalescore.modulos.pedido.adapters.PedidosAdapter
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.PedidoClickListener

class PedidosListViewModel(ctx: Context, listener : PedidoClickListener) : ViewModel() {

    var context     : Context = ctx
    var pedidosBase : List<Pedido> = ArrayList()
    var adapter     : PedidosAdapter

    var db = AppDatabase.getAppDatabase(context)

    /**Observer da lista de clienteBases*/
    private val recycler_main = MutableLiveData<PedidosAdapter>().apply {
        pedidosBase = db.pedidoDao().getAll()
        adapter = PedidosAdapter(
            ctx,
            pedidosBase,
            listener
        )
        value = adapter
    }
    val recycler: LiveData<PedidosAdapter> = recycler_main

    private val _title = MutableLiveData<String>().apply {
        value = ctx.getString(R.string.menu_pedidos)
    }
    val textTitle: LiveData<String> = _title

    private val _subtitle = MutableLiveData<String>().apply {
        value = ctx.getString(R.string.menu_pedidos_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle



    /**Comandos*/
    fun refreshAdapter(){
        (pedidosBase as ArrayList).clear()
        (pedidosBase as ArrayList).addAll(db.pedidoDao().getAll())
        adapter.notifyDataSetChanged()
    }

    fun deletePedido(pedido : Pedido){
        var db = AppDatabase.getAppDatabase(context)
        db.pedidoDao().delete(pedido)
        refreshAdapter()
    }

    /**Popups*/
    fun mostrarPopUp(view : View , position : Int){
        val popup = PopupMenu(context, view)
        popup.inflate(R.menu.popup_menu_pedidos)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_pedido_detalhes -> {
                    Toast.makeText(context, "teste de click...", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_pedido_excluir -> {
                    mostraConfirmacaoExclusao(position)
                }
            }
            false
        }
        popup.show()
    }

    fun mostrarConfirmacaoSincronizacao(){
        MaterialAlertDialogBuilder(context)
            .setTitle("SINCRONIZAÇÃO")
            .setMessage("Deseja sincronizar as informações sobre clienteBases?\n\nIsso significa TRANSMITIR/RECEBER informações sobre clienteBases")
            .setPositiveButton("Sim, sincronize")
            {
                    dialog , which -> Toast.makeText(context, "sincronizar informações", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Não")
            {
                    dialog , which -> Toast.makeText(context, "não sincronizar informações", Toast.LENGTH_SHORT).show()
            }
            .setCancelable(false)
            .setIcon(R.drawable.ic_clientes)
            .show()
    }

    /**Dialogs*/
    fun mostraConfirmacaoExclusao(position : Int){
        val pedido = pedidosBase.get(position)
        MaterialAlertDialogBuilder(context)
            .setTitle("Atenção")
            .setIcon(R.drawable.ic_clientes)
            .setCancelable(false)
            .setMessage("Deseja mesmo excluir o Pedido ${pedido.referenceCode} ?")
            .setPositiveButton("SIM, excluir")
            {
                    dialog, which -> deletePedido(pedido)
            }
            .setNegativeButton("NÃO")
            {
                    dialog, which -> Toast.makeText(context,"Exclusão cancelada!", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

}