package com.mobilesales.mobilesalescore.modulos.condicao_pagamento.views.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mobilesales.mobilesalescore.R
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.modulos.cliente.adapters.ClientesSimpleAdapter
import com.mobilesales.mobilesalescore.modulos.cliente.interfaces.ClienteClickListener
import com.mobilesales.mobilesalescore.modulos.condicao_pagamento.adapters.CondicaoPagamentoSimpleAdapter
import com.mobilesales.mobilesalescore.modulos.condicao_pagamento.interfaces.CondicaoPagamentoClickListener
import com.mobilesales.mobilesalescore.modulos.tipo_pedido.adapters.TipoPedidoSimpleAdapter
import com.mobilesales.mobilesalescore.modulos.tipo_pedido.interfaces.TipoPedidoClickListener
import com.mobilesales.mobilesalescore.modulos.transportadora.adapters.TransportadoraSimpleAdapter
import com.mobilesales.mobilesalescore.modulos.transportadora.interfaces.TransportadoraClickListener
import kotlinx.android.synthetic.main.dynamic_dialog_select.view.*

class CondicaoPagamentoDialogSelect : DialogFragment(){

    var simpleAdapter : CondicaoPagamentoSimpleAdapter? = null
    lateinit var db : AppDatabase
    lateinit var dialogBuilder : AlertDialog
    lateinit var listener: CondicaoPagamentoClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        setStyle(STYLE_NORMAL, R.style.ThemeOverlay_MaterialComponents_Dialog)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * Criação do dialog ---------------------------------------------------------------------------
     **/
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initComponents()

        val inflater = activity!!.layoutInflater
        var view  = inflater.inflate(R.layout.dynamic_dialog_select, null)

        dialogBuilder.setView(view)
        dialogBuilder.setTitle(R.string.selecione_uma_transportadora)
        dialogBuilder.setIcon(R.drawable.ic_pedido_section)
        dialogBuilder.setCancelable(false)
        dialogBuilder.setCanceledOnTouchOutside(false)

        view.dynamic_dialog_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.dynamic_dialog_recycler.adapter = simpleAdapter

        return dialogBuilder
    }

    companion object {
        fun newInstance(listener: CondicaoPagamentoClickListener): CondicaoPagamentoDialogSelect {
            val frag = CondicaoPagamentoDialogSelect()
            val args = Bundle()
            frag.arguments = args
            frag.listener = listener
            return frag
        }
    }

    fun initComponents(){
        dialogBuilder =  AlertDialog.Builder(context!!).create()
        db = AppDatabase.getAppDatabase(context!!)
        simpleAdapter = CondicaoPagamentoSimpleAdapter(context!!, db.condicaoPagamentoDao().getAll(), listener)
    }


}

