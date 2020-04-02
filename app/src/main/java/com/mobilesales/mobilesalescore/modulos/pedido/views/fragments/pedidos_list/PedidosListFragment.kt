package com.mobilesales.mobilesalescore.ui.pedidos

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.enum.EnumPedidoEstado
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import com.mobilesales.mobilesalescore.modulos.cliente.views.fragments.cliente_main.ClientesViewModel
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.PedidoClickListener
import com.mobilesales.mobilesalescore.ui.gallery.PedidosListViewModel
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.titulos_row.view.*

class PedidosListFragment : Fragment(), PedidoClickListener {

    private lateinit var recycler : RecyclerView
    private lateinit var pedidosListViewModel: PedidosListViewModel
    lateinit var navController : NavController

    override fun onAbrirCabecalhoPedido(pedido : Pedido) {
        var bundle = Bundle()
        bundle.putString("CODE", EnumPedidoEstado.PEDIDO_ESTADO_EXISTENTE.toString())
        bundle.putString("PEDIDO_REFERENCE", pedido.referenceCode)
        navController!!.navigate(R.id.action_nav_lista_pedidos_to_nav_pedido, bundle)
    }

    override fun onPedidoClickOptions(view: View, position: Int) {
        pedidosListViewModel.mostrarPopUp(view , position)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        pedidosListViewModel = ViewModelProviders.of(this, PedidosListViewModelFactory(context!!, this)).get(PedidosListViewModel::class.java)

        val root          = inflater.inflate(R.layout.fragment_pedidos, container, false)
        val title: TextView     = activity!!.main_toolbar_label
        val subTitle: TextView  = activity!!.main_toolbar_sublabel

        recycler = root.findViewById(R.id.pedidos_recycler_pedidos)

        pedidosListViewModel.recycler.observe(this, Observer {
            recycler.adapter = it
            recycler.layoutManager = LinearLayoutManager(context)
        })

        pedidosListViewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        pedidosListViewModel.textSubtitle.observe(this, Observer {
            subTitle.text = it
        })

        setHasOptionsMenu(true)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onResume() {
        super.onResume()
        pedidosListViewModel.refreshAdapter()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_basic, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menu_adicionar -> {
            var bundle = Bundle()
            bundle.putString("CODE", "PEDIDO_ESTADO_NOVO")
            bundle.putString("PEDIDO_REFERENCE", "")
            navController!!.navigate(R.id.action_nav_lista_pedidos_to_nav_pedido, bundle)
            true
        }
        R.id.menu_sincronizar ->{
            Toast.makeText(context!!, "ação de clique na sincronização", Toast.LENGTH_SHORT).show()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}