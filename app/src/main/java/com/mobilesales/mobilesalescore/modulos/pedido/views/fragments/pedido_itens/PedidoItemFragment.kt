package com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_itens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.pedido_item.PedidoItem
import com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_cabecalho.PedidoCabecalhoFragment
import com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_itens.adapters.PedidoCabecalhoItemAdapter
import kotlinx.android.synthetic.main.fragment_pedido_item.view.*

/**
 * A simple [Fragment] subclass.
 */
class PedidoItemFragment : Fragment() {

    lateinit var adapter: PedidoCabecalhoItemAdapter
    lateinit var db : AppDatabase
    private  var pedidoRef:        String? = null
    val PEDIDO_REFERENCE  = "PEDIDO_REFERENCE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pedidoRef   = it.getString(PEDIDO_REFERENCE)
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val root = inflater.inflate(R.layout.fragment_pedido_item, container, false)

        initiate()

        adapter = PedidoCabecalhoItemAdapter(context!!, getItens() )
        root.pedido_cabecalho_recycler_item.adapter = adapter
        root.pedido_cabecalho_recycler_item.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()

        return root
    }

    fun getItens() : List<PedidoItem>{
        var list : List<PedidoItem> = ArrayList()

        list = db.pedidoItemDao().loadAllByRef(pedidoRef!!)

        return list
    }

    companion object {
        @JvmStatic
        fun newInstance(reference : String) =
            PedidoItemFragment().apply {
                arguments = Bundle().apply {
                    putString("PEDIDO_REFERENCE", reference)
                }
            }
    }

    fun initiate(){
        initData()
        initComponent()
        initListeners()
    }

    fun initComponent(){

    }

    fun initListeners(){

    }

    fun initData(){
        db = AppDatabase.getAppDatabase(context!!)
    }


}
