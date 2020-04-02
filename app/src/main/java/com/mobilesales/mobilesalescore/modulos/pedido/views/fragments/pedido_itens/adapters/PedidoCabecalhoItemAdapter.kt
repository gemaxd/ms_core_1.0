package com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_itens.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.pedido_item.PedidoItem
import com.mobilesales.mobilesalescore.modulos.cliente.interfaces.ClienteClickListener
import kotlinx.android.synthetic.main.pedido_item_row.view.*
import android.animation.Animator


class PedidoCabecalhoItemAdapter(context : Context, val itens : List<PedidoItem>) : RecyclerView.Adapter<PedidoItemViewHolder>() {

    var mContext = context
    var mClientes = itens

    override fun getItemCount(): Int {
        return mClientes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidoItemViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cellClientes = layoutInflater.inflate(R.layout.pedido_item_row, parent , false)
        return PedidoItemViewHolder(
            cellClientes
        )
    }

    override fun onBindViewHolder(holder: PedidoItemViewHolder, position: Int) {
        val item = mClientes[position]
        holder.nome.editText!!.setText(item.descProduto)
        holder.valUnitario.editText!!.setText(item.valUnitario.toString())
        holder.valTotal.editText!!.setText(item.valLiquido.toString())
    }
}

class PedidoItemViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView), View.OnClickListener{
    val nome            = itemView.pedido_item_descricao
    val quantidade      = itemView.pedido_item_quantidade
    val valUnitario     = itemView.pedido_item_valor_unitario
    val valTotal        = itemView.pedido_item_valor_total


    fun setOnClienteItemClickListener(clickListener: ClienteClickListener){
        //this.clienteClickListener = clickListener
    }

    override fun onClick(view: View?) {
        //this.clienteClickListener.onClienteClickOptions(view!!, adapterPosition)
    }

}