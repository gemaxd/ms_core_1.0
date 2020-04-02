package com.mobilesales.mobilesalescore.modulos.tipo_pedido.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.pedido.TipoPedido
import com.mobilesales.mobilesalescore.modulos.tipo_pedido.interfaces.TipoPedidoClickListener
import kotlinx.android.synthetic.main.simple_adapter_row.view.*

class TipoPedidoSimpleAdapter(context : Context, val tipoPedidos : List<TipoPedido>, listener : TipoPedidoClickListener)
    : RecyclerView.Adapter<ClientesSimpleViewHolder>() {

    var mContext = context
    var mListener = listener
    var mTipos = tipoPedidos

    override fun getItemCount(): Int {
        return mTipos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientesSimpleViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cellClientes = layoutInflater.inflate(R.layout.simple_adapter_row, parent , false)
        return ClientesSimpleViewHolder( cellClientes , mTipos )
    }

    override fun onBindViewHolder(holder: ClientesSimpleViewHolder, position: Int) {
        val tipoPedido     = mTipos[position]
        holder.descricao.text    = tipoPedido.nomTipoPedido
        holder.setOnClienteItemClickListener(mListener)
    }
}

class ClientesSimpleViewHolder(itemView : View, tipos : List<TipoPedido>)  : RecyclerView.ViewHolder(itemView){

    val descricao       = itemView.simple_adapter_descricao
    val cardClienteCard = itemView.simple_adapter_card

    lateinit var tipoPedidoListener : TipoPedidoClickListener

    init {
        cardClienteCard.setOnClickListener { selecionarCliente(tipos[adapterPosition]) }
    }

    fun setOnClienteItemClickListener(listener: TipoPedidoClickListener){
        this.tipoPedidoListener = listener
    }

    fun selecionarCliente(tipo : TipoPedido){
        this.tipoPedidoListener.onTipoPedidoSelectOptions(tipo)
    }

}