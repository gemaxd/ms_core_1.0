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
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.TitulosItemClickListener
import kotlinx.android.synthetic.main.titulos_row.view.*


class TitulosAdapter(context : Context, listener : TitulosItemClickListener) : RecyclerView.Adapter<TitulosViewHolder>() {

    var mContext = context
    var mListener = listener

    override fun getItemCount(): Int {
        return 6
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitulosViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellPedidos = layoutInflater.inflate(R.layout.titulos_row, parent , false)
        return TitulosViewHolder(cellPedidos)
    }

    override fun onBindViewHolder(holder: TitulosViewHolder, position: Int) {
        holder.setOnClienteItemClickListener(mListener)
    }

}

class TitulosViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView), View.OnClickListener{
    val options     = itemView.titulos_btn_options
    lateinit var titulosItemClickListener: TitulosItemClickListener

    init {
        options.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        this.titulosItemClickListener.onTituloClickOptions(view!!, adapterPosition)
    }

    fun setOnClienteItemClickListener(clickListener: TitulosItemClickListener){
        this.titulosItemClickListener = clickListener
    }

}