package com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import com.mobilesales.mobilesalescore.models.enum.EnumPedidoEstado
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import com.mobilesales.mobilesalescore.modulos.cliente.interfaces.ClienteClickListener
import com.mobilesales.mobilesalescore.modulos.cliente.views.dialog.ClienteDialogSelect
import com.mobilesales.mobilesalescore.modulos.pedido.adapters.PedidoPagerAdapter
import com.mobilesales.mobilesalescore.modulos.pedido.managers.PedidoManager
import com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_cabecalho.PedidoCabecalhoFragment
import com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_itens.PedidoItemFragment
import com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_valores.PedidoValoresFragment
import com.mobilesales.mobilesalescore.ui.gallery.PedidoViewModel
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_pedido.view.*

class PedidoFragment : Fragment() {

    private lateinit var pedidoViewModel: PedidoViewModel
    var estadoPedido : String = ""
    var codigoPedido : String = ""

    lateinit var db : AppDatabase

    var managerPedido = PedidoManager()

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        pedidoViewModel = ViewModelProviders.of(this, PedidoViewModelFactory(context!!)).get(PedidoViewModel::class.java)
        db = AppDatabase.getAppDatabase(context!!)

        val root = inflater.inflate(R.layout.fragment_pedido, container, false)

        estadoPedido = arguments!!.getString("CODE")!!
        codigoPedido = arguments!!.getString("PEDIDO_REFERENCE")!!

        val title:     TextView  = activity!!.main_toolbar_label
        val subTitle:  TextView  = activity!!.main_toolbar_sublabel
        var topBar:    TabLayout = root.pedido_top_nav
        val viewPager: ViewPager = root.pager

        val adapter = PedidoPagerAdapter(childFragmentManager)
        populateFragments(adapter, codigoPedido)

        viewPager.adapter = adapter
        topBar.setupWithViewPager(viewPager)

        pedidoViewModel.textTitle.observe(this, Observer { title.text = it })
        pedidoViewModel.textSubtitle.observe(this, Observer { subTitle.text = it })
        return root
    }

    fun populateFragments(adapter : PedidoPagerAdapter, reference : String){
        var ped : Pedido? = db.pedidoDao().getById(reference)

        if(ped == null){
            if(estadoPedido.equals(EnumPedidoEstado.PEDIDO_ESTADO_NOVO.toString())){
                ped = managerPedido.gerarPedidoNovo(db.pedidoDao().getAll().size, context!!)
                db.pedidoDao().insertAll(ped)
            }
            adapter.addFragment(PedidoCabecalhoFragment.newInstance(EnumPedidoEstado.PEDIDO_ESTADO_NOVO.toString(), ped!!.referenceCode), "CABEÇALHO")
        }else{
            adapter.addFragment(PedidoCabecalhoFragment.newInstance(EnumPedidoEstado.PEDIDO_ESTADO_EXISTENTE.toString(), ped!!.referenceCode), "CABEÇALHO")
        }

        adapter.addFragment(PedidoValoresFragment.newInstance(ped!!.referenceCode), "VALORES")
        adapter.addFragment(PedidoItemFragment.newInstance(ped!!.referenceCode), "ITENS")
    }

}