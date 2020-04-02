/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/11/19 5:34 PM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/10/19 4:57 PM
 -------------------------------------------------------------------------------------------------*/

package com.mobilesales.mobilesalescore.modulos.pedido.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.enum.EnumPedidoStatus
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.PedidoClickListener
import kotlinx.android.synthetic.main.clientes_row.view.pedidos_btn_expandir
import kotlinx.android.synthetic.main.clientes_row.view.pedidos_btn_options
import kotlinx.android.synthetic.main.pedidos_row.view.*

class PedidosAdapter(context : Context,val pedidosBase : List<Pedido>, listener : PedidoClickListener) : RecyclerView.Adapter<PedidosViewHolder>() {

    var mContext    = context
    var mListener   = listener
    var mPedidos    = pedidosBase

    override fun getItemCount(): Int {
        return mPedidos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidosViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellPedidos = layoutInflater.inflate(R.layout.pedidos_row, parent , false)
        return PedidosViewHolder(cellPedidos, mPedidos)
    }

    override fun onBindViewHolder(holder: PedidosViewHolder, position: Int) {
        val ped = mPedidos[position]
        holder.setOnClienteItemClickListener(mListener)
        holder.expandir.setOnClickListener(OnClickListener {
            if(holder.layoutAdicional.visibility === View.GONE){
                holder.layoutAdicional.visibility = View.VISIBLE
                holder.imgExpandir.setImageDrawable(mContext.getDrawable(R.drawable.ic_expandir_acima))
            }else{
                holder.layoutAdicional.visibility = View.GONE
                holder.imgExpandir.setImageDrawable(mContext.getDrawable(R.drawable.ic_expandir_abaixo))
            }
        })

        if(ped.pedidoAtivo.equals("A")){
            holder.marcador.setBackgroundColor(mContext.resources.getColor(R.color.translucide_ms_orange))
        }else{
            holder.marcador.setBackgroundColor(mContext.resources.getColor(R.color.TranslucideWhite))
        }

        holder.nome.setText(ped.clienteNome)
        holder.referenceCode.setText(ped.referenceCode)
        holder.valorLiquido.setText(mContext.resources.getString(R.string.monetario_float2, ped.valLiquido))
        holder.quantidade.setText(ped.quantidade_itens.toString())

        holder.situacao.setText(ped.sitPedido)

        if(ped.sitPedido.equals(EnumPedidoStatus.ABERTO.toString())){
            holder.situacao.setTextColor(mContext.resources.getColor(R.color.Green))
        } else if(ped.sitPedido.equals(EnumPedidoStatus.TRANSMITIR.toString())) {
            holder.situacao.setTextColor(mContext.resources.getColor(R.color.Orange))
        } else {
            holder.situacao.setTextColor(mContext.resources.getColor(R.color.Black))
        }
    }
}

class PedidosViewHolder(itemView : View, pedidos: List<Pedido>)  : RecyclerView.ViewHolder(itemView){
    val nome            = itemView.pedido_cliente_nome
    val options         = itemView.pedidos_btn_options
    val expandir        = itemView.pedidos_btn_expandir
    val layoutAdicional = itemView.ll_adicional
    var imgExpandir     = itemView.pedidos_imgbtn_expandir
    val cardPedidos     = itemView.pedidos_row_entire
    val situacao        = itemView.pedido_situacao
    val quantidade      = itemView.pedido_quantidade
    val valorLiquido    = itemView.pedido_valor_liquido
    val referenceCode   = itemView.pedido_reference_code
    val marcador        = itemView.row_pedidos_marcador
    lateinit var pedidoClickListener : PedidoClickListener

    init {
        options.setOnClickListener{ mostrarOpcoes(options) }
        cardPedidos.setOnClickListener{ abrirCabecalhoPedido(pedidos[adapterPosition]) }
    }

    private fun mostrarOpcoes(view : View?){
        this.pedidoClickListener!!.onPedidoClickOptions(view!!, adapterPosition)
    }

    private fun abrirCabecalhoPedido(pedido : Pedido){
        this.pedidoClickListener!!.onAbrirCabecalhoPedido(pedido)
    }

    fun setOnClienteItemClickListener(listener: PedidoClickListener){
        this.pedidoClickListener = listener
    }
}