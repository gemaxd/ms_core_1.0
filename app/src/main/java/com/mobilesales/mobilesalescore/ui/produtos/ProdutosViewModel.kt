package com.mobilesales.mobilesalescore.ui.gallery

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import com.mobilesales.mobilesalescore.models.pedido_item.PedidoItem
import com.mobilesales.mobilesalescore.models.pedido_item.Produto
import com.mobilesales.mobilesalescore.ui.clientes.adapters.ProdutosAdapter
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.ProdutosItemClickListener
import java.util.*
import kotlin.collections.ArrayList

class ProdutosViewModel(ctx : Context, listener : ProdutosItemClickListener) : ViewModel() {

    var context : Context = ctx
    var produtos : List<Produto> = ArrayList()

    var db = AppDatabase.getAppDatabase(context)

    private val recycler_main = MutableLiveData<ProdutosAdapter>().apply {
        produtos = db.produtoDao().getAll()
        value = ProdutosAdapter(ctx , produtos , listener)
    }
    val recycler: LiveData<ProdutosAdapter> = recycler_main

    private val _title = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_produtos)
    }
    val textTitle: LiveData<String> = _title


    private val _subtitle = MutableLiveData<String>().apply {
        value = context.getString(R.string.menu_produtos_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle

    /**Popups*/
    fun mostrarPopUp(view : View, position : Int){
        val popup = PopupMenu(context, view)
        popup.inflate(R.menu.popup_menu_produtos)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_adicionar -> {
                    Toast.makeText(context, "teste de click...", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_clientes_excluir -> {
                    //mostraConfirmacaoExclusao(position)
                }
            }
            false
        }
        popup.show()
    }

    fun mostrarConfirmacaoInsercao(pro : Produto){
        MaterialAlertDialogBuilder(context)
            .setTitle("QUICK ADD")
            .setView(R.layout.layout_produto_quick_add)
            .setPositiveButton("Inserir")
            {
                    dialog , which -> inserirItem(pro)
            }
            .setNegativeButton("Cancelar")
            {
                    dialog , which -> Toast.makeText(context, "inserção cancelada", Toast.LENGTH_SHORT).show()
            }
            .setIcon(R.drawable.ic_sair)
            .setCancelable(false)
            .show()
    }


    fun inserirItem(pro : Produto){
        var pedido = db.pedidoDao().getPedidoAtivo()
        var item = PedidoItem()
        item.codProduto             = pro.codProduto
        item.referenceCode          = UUID.randomUUID().toString()
        item.pedidoReferenceCode    = pedido.referenceCode
        item.descProduto            = pro.descProduto

        db.pedidoItemDao().insertAll(item)
    }
}