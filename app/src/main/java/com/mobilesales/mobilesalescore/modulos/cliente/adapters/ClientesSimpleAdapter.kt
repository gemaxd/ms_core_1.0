package com.mobilesales.mobilesalescore.modulos.cliente.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import com.mobilesales.mobilesalescore.modulos.cliente.interfaces.ClienteClickListener
import kotlinx.android.synthetic.main.clientes_row.view.cliente_cnpj
import kotlinx.android.synthetic.main.clientes_row.view.cliente_endereco
import kotlinx.android.synthetic.main.clientes_row.view.cliente_nome
import kotlinx.android.synthetic.main.clientes_row.view.pedidos_btn_options
import kotlinx.android.synthetic.main.clientes_simple_row.view.*

class ClientesSimpleAdapter(context : Context, val clienteBases : List<Cliente>, listener : ClienteClickListener)
    : RecyclerView.Adapter<ClientesSimpleViewHolder>() {

    var mContext = context
    var mListener = listener
    var mClientes = clienteBases

    override fun getItemCount(): Int {
        return mClientes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientesSimpleViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cellClientes = layoutInflater.inflate(R.layout.clientes_simple_row, parent , false)
        return ClientesSimpleViewHolder(
            cellClientes
            , mClientes
        )
    }

    override fun onBindViewHolder(holder: ClientesSimpleViewHolder, position: Int) {
        val cliente     = mClientes[position]
        holder.nome.text        = cliente.nomCli
        holder.cpfCnpj.text     = cliente.cliCpfCnpj
        holder.endereco.text    = cliente.cliEnd
        holder.setOnClienteItemClickListener(mListener)
    }
}

class ClientesSimpleViewHolder(itemView : View, clientes : List<Cliente>)  : RecyclerView.ViewHolder(itemView){

    val nome        = itemView.cliente_nome
    val endereco    = itemView.cliente_endereco
    val cpfCnpj     = itemView.cliente_cnpj
    val options     = itemView.pedidos_btn_options
    val cardClienteCard = itemView.cliente_simple_card

    lateinit var clienteClickListener : ClienteClickListener

    init {
        cardClienteCard.setOnClickListener { selecionarCliente(clientes[adapterPosition]) }
    }

    fun setOnClienteItemClickListener(clickListener: ClienteClickListener){
        this.clienteClickListener = clickListener
    }

    fun selecionarCliente(cliente : Cliente){
        this.clienteClickListener.onClienteSelectOptions(cliente)
    }

}