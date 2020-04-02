package com.mobilesales.mobilesalescore.modulos.cliente.views.fragments.cliente_main

import android.content.Context
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import com.mobilesales.mobilesalescore.modulos.cliente.adapters.ClientesStandardAdapter
import com.mobilesales.mobilesalescore.modulos.cliente.interfaces.ClienteClickListener

class ClientesViewModel(ctx : Context, listener : ClienteClickListener) : ViewModel() {

    var context      : Context = ctx
    var clienteBases : List<Cliente> = ArrayList()
    var standardAdapter      : ClientesStandardAdapter

    var db = AppDatabase.getAppDatabase(context)

    /**Observer da lista de clienteBases*/
    private val recycler_main = MutableLiveData<ClientesStandardAdapter>().apply {
        clienteBases = db.clienteDao().getAll()
        standardAdapter = ClientesStandardAdapter(
            ctx,
            clienteBases,
            listener
        )
        value = standardAdapter
    }
    val recycler: LiveData<ClientesStandardAdapter> = recycler_main

    /**Observer da descrição de titulo*/
    private val _title = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_clientes)
    }
    val textTitle: LiveData<String> = _title

    /**Observer da descrição de subtitulo*/
    private val _subtitle = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_clientes_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle


    /**Comandos*/
    fun refreshAdapter(){
        (clienteBases as ArrayList).clear()
        (clienteBases as ArrayList).addAll(db.clienteDao().getAll())
        standardAdapter.notifyDataSetChanged()
    }

    fun deleteCliente(cliente : Cliente){
        var db = AppDatabase.getAppDatabase(context)
        db.clienteDao().delete(cliente)
        refreshAdapter()
    }

    /**Popups*/
    fun mostrarPopUp(view : View , position : Int){
        val popup = PopupMenu(context, view)
        popup.inflate(R.menu.popup_menu_clientes)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_clientes_detalhes -> {
                    Toast.makeText(context, "teste de click...", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_clientes_excluir -> {
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
            .setPositiveButton("Sim, sincronize") {
                    dialog , which -> Toast.makeText(context, "sincronizar informações", Toast.LENGTH_SHORT).show()
                }
            .setNegativeButton("Não") {
                    dialog , which -> Toast.makeText(context, "não sincronizar informações", Toast.LENGTH_SHORT).show()
                }
            .setCancelable(false)
            .setIcon(R.drawable.ic_clientes)
            .show()
    }

    /**Dialogs*/
    fun mostraConfirmacaoExclusao(position : Int){
        val cliente = clienteBases.get(position)
        MaterialAlertDialogBuilder(context)
            .setTitle("Atenção")
            .setIcon(R.drawable.ic_clientes)
            .setCancelable(false)
            .setMessage("Deseja mesmo excluir o cliente ${cliente.nomCli} ?")
            .setPositiveButton("SIM, excluir") { dialog, which -> deleteCliente(cliente) }
            .setNegativeButton("NÃO") { dialog, which -> Toast.makeText(context,"Exclusão cancelada!",Toast.LENGTH_SHORT).show() }
            .show()
    }



}