package com.mobilesales.mobilesalescore.modulos.condicao_pagamento.adapters

    import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.pedido.CondicaoPagamento
import com.mobilesales.mobilesalescore.modulos.condicao_pagamento.interfaces.CondicaoPagamentoClickListener
import kotlinx.android.synthetic.main.simple_adapter_kv_row.view.*
import kotlinx.android.synthetic.main.simple_adapter_row.view.simple_adapter_card
import kotlinx.android.synthetic.main.simple_adapter_row.view.simple_adapter_descricao

class CondicaoPagamentoSimpleAdapter(context : Context, val lista : List<CondicaoPagamento>, listener : CondicaoPagamentoClickListener)
    : RecyclerView.Adapter<CondicaoPagamentoViewHolder>() {

    var mContext = context
    var mListener = listener
    var mLista = lista

    override fun getItemCount(): Int {
        return mLista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CondicaoPagamentoViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cellClientes = layoutInflater.inflate(R.layout.simple_adapter_kv_row, parent , false)
        return CondicaoPagamentoViewHolder( cellClientes , mLista )
    }

    override fun onBindViewHolder(holder: CondicaoPagamentoViewHolder, position: Int) {
        val objeto     = mLista[position]
        holder.descricao.text  = objeto.nomCondicaoPagamento
        holder.percentual.text = objeto.percDescontoAcrescimo.toString()
        holder.setOnClienteItemClickListener(mListener)
    }
}

class CondicaoPagamentoViewHolder(itemView : View, lista : List<CondicaoPagamento>)  : RecyclerView.ViewHolder(itemView){

    val descricao   = itemView.simple_adapter_descricao
    val percentual  = itemView.simple_adapter_percentual
    val card        = itemView.simple_adapter_card

    lateinit var tipoPedidoListener : CondicaoPagamentoClickListener

    init {
        card.setOnClickListener { selecionarObjeto(lista[adapterPosition]) }
    }

    fun setOnClienteItemClickListener(listener: CondicaoPagamentoClickListener){
        this.tipoPedidoListener = listener
    }

    fun selecionarObjeto(condicaoPagamento: CondicaoPagamento){
        this.tipoPedidoListener.onCondicaoPagamentoSelect(condicaoPagamento)
    }

}