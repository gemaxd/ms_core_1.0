package com.mobilesales.mobilesalescore.modulos.transportadora.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.pedido.Transportadora
import com.mobilesales.mobilesalescore.modulos.transportadora.interfaces.TransportadoraClickListener
import kotlinx.android.synthetic.main.simple_adapter_row.view.*

class TransportadoraSimpleAdapter(context : Context, val lista : List<Transportadora>, listener : TransportadoraClickListener)
    : RecyclerView.Adapter<ClientesSimpleViewHolder>() {

    var mContext = context
    var mListener = listener
    var mLista = lista

    override fun getItemCount(): Int {
        return mLista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientesSimpleViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cellClientes = layoutInflater.inflate(R.layout.simple_adapter_row, parent , false)
        return ClientesSimpleViewHolder( cellClientes , mLista )
    }

    override fun onBindViewHolder(holder: ClientesSimpleViewHolder, position: Int) {
        val objeto     = mLista[position]
        holder.descricao.text    = objeto.nomeTransportadora
        holder.setOnClienteItemClickListener(mListener)
    }
}

class ClientesSimpleViewHolder(itemView : View, lista : List<Transportadora>)  : RecyclerView.ViewHolder(itemView){

    val descricao   = itemView.simple_adapter_descricao
    val card        = itemView.simple_adapter_card

    lateinit var tipoPedidoListener : TransportadoraClickListener

    init {
        card.setOnClickListener { selecionarObjeto(lista[adapterPosition]) }
    }

    fun setOnClienteItemClickListener(listener: TransportadoraClickListener){
        this.tipoPedidoListener = listener
    }

    fun selecionarObjeto(transportadora : Transportadora){
        this.tipoPedidoListener.onTransportadorsSelect(transportadora)
    }

}