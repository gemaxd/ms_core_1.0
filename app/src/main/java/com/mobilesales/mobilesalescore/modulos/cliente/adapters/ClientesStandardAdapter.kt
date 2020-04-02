package com.mobilesales.mobilesalescore.modulos.cliente.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import com.mobilesales.mobilesalescore.modulos.cliente.interfaces.ClienteClickListener
import kotlinx.android.synthetic.main.clientes_row.view.*

class ClientesStandardAdapter(context : Context, val clienteBases : List<Cliente>, listener : ClienteClickListener)
    : RecyclerView.Adapter<ClientesStandardViewHolder>() {

    var mContext = context
    var mListener = listener
    var mClientes = clienteBases

    override fun getItemCount(): Int {
        return mClientes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientesStandardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cellClientes = layoutInflater.inflate(R.layout.clientes_row, parent , false)
        return ClientesStandardViewHolder(
            cellClientes
        )
    }

    override fun onBindViewHolder(holder: ClientesStandardViewHolder, position: Int) {
        val cliente     = mClientes[position]
        holder.nome.text        = cliente.nomCli
        holder.cpfCnpj.text     = cliente.cliCpfCnpj
        holder.endereco.text    = cliente.cliEnd

        holder.setOnClienteItemClickListener(mListener)
    }
}

class ClientesStandardViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView), View.OnClickListener{

    val nome        = itemView.cliente_nome
    val endereco    = itemView.cliente_endereco
    val cpfCnpj     = itemView.cliente_cnpj
    val options     = itemView.pedidos_btn_options
    lateinit var clienteClickListener : ClienteClickListener

    init {
        options.setOnClickListener(this)
    }

    fun setOnClienteItemClickListener(clickListener: ClienteClickListener){
        this.clienteClickListener = clickListener
    }

    override fun onClick(view: View?) {
        this.clienteClickListener.onClienteClickOptions(view!!, adapterPosition)
    }

}