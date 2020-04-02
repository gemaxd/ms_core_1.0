package com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_valores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import kotlinx.android.synthetic.main.fragment_pedido_valores.*

/**
 * A simple [Fragment] subclass.
 */
private const val PEDIDO_REFERENCE  = "PEDIDO_REFERENCE"

class PedidoValoresFragment : Fragment() {

    private var pedidoRef:     String? = null
    lateinit var db: AppDatabase
    lateinit var pedido: Pedido

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pedidoRef   = it.getString(PEDIDO_REFERENCE)
        }
    }
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pedido_valores, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        pedido = db.pedidoDao().getById(pedidoRef!!)
        refreshViews()
    }

    fun refreshViews(){
        ped_item_valor_total_liquido.setText(pedido.valLiquido.toString())
        ped_item_valor_total_bruto.setText(pedido.valBruto.toString())
        ped_item_valor_total_ipi.setText(pedido.valIpi.toString())
        ped_item_valor_total_difal.setText(pedido.valDifal.toString())
        ped_item_valor_total_transporte.setText(pedido.valTransporte.toString())
        ped_item_valor_total_st.setText(pedido.valIcmsSubstituido.toString())
        ped_item_valor_total_acrescimo.setText(pedido.valAcrescimo.toString())
        ped_item_valor_total_desconto.setText(pedido.valDesconto.toString())
    }

    fun initData(){
        db          = AppDatabase.getAppDatabase(context!!)
        pedido      = db.pedidoDao().getById(pedidoRef!!)
    }

    companion object {
        @JvmStatic
        fun newInstance(reference : String) =
            PedidoValoresFragment().apply {
                arguments = Bundle().apply {
                    putString(PEDIDO_REFERENCE, reference)
                }
            }
    }

}
