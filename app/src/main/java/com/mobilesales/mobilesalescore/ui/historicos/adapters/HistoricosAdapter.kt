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
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.HistoricotemClickListener
import kotlinx.android.synthetic.main.clientes_row.view.*


class HistoricosAdapter(context : Context, listener : HistoricotemClickListener) : RecyclerView.Adapter<HistoricosViewHolder>() {

    var mContext = context
    var mListener = listener

    override fun getItemCount(): Int {
        return 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricosViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellPedidos = layoutInflater.inflate(R.layout.pedidos_row, parent , false)
        return HistoricosViewHolder(cellPedidos)
    }

    override fun onBindViewHolder(holder: HistoricosViewHolder, position: Int) {
        holder.setOnHistoricoItemClickListener(mListener)
    }

}

class HistoricosViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView), View.OnClickListener{
    val nome        = itemView.cliente_nome
    val endereco    = itemView.cliente_endereco
    val cpfCnpj     = itemView.cliente_cnpj
    val options     = itemView.pedidos_btn_options
    lateinit var pedidoItemClickListener : HistoricotemClickListener

    init {
        options.setOnClickListener(this)
    }

    fun setOnHistoricoItemClickListener(clickListener: HistoricotemClickListener){
        this.pedidoItemClickListener = clickListener
    }

    override fun onClick(view: View?) {
        this.pedidoItemClickListener!!.onHistoricoClickOptions(view!!, adapterPosition)
    }

}