/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/11/19 5:34 PM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/10/19 4:57 PM
 -------------------------------------------------------------------------------------------------*/

package com.mobilesales.mobilesalescore.ui.clientes.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import com.mobilesales.mobilesalescore.models.pedido_item.PedidoItem
import com.mobilesales.mobilesalescore.models.pedido_item.Produto
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.ProdutosItemClickListener
import kotlinx.android.synthetic.main.produtos_row.view.*
import kotlinx.android.synthetic.main.titulos_row.view.*

class ProdutosAdapter(context : Context, val itens : List<Produto>, listener : ProdutosItemClickListener) : RecyclerView.Adapter<ProdutosViewHolder>() {

    var mContext = context
    var mListener = listener
    var mItens = itens

    override fun getItemCount(): Int {
        return mItens.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellPedidos = layoutInflater.inflate(R.layout.produtos_row, parent , false)
        return ProdutosViewHolder(cellPedidos)
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val item = mItens[position]
        holder.setOnClienteItemClickListener(mListener)

        holder.quickAdd.setOnClickListener {
            mListener.onProdutoClickQuickAdd(it, item)
        }

        holder.codigo.setText(item.codProduto)
    }
}

class ProdutosViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView), View.OnClickListener{
    val codigo      = itemView.produto_cod_pro
    val options     = itemView.produtos_option
    val quickAdd    = itemView.produtos_quick_add
    lateinit var produtosItemClickListener: ProdutosItemClickListener

    init {
        options.setOnClickListener{ mostrarOpcoes(options) }
    }

    private fun mostrarOpcoes(view : View){
        this.produtosItemClickListener!!.onProdutoClickOptions(view, adapterPosition)
    }

    override fun onClick(view: View?) {
        this.produtosItemClickListener.onProdutoClickOptions(view!!, adapterPosition)
    }

    fun setOnClienteItemClickListener(clickListener: ProdutosItemClickListener){
        this.produtosItemClickListener = clickListener
    }

}