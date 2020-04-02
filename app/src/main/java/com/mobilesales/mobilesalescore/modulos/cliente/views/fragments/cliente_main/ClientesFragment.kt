package com.mobilesales.mobilesalescore.modulos.cliente.views.fragments.cliente_main

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import com.mobilesales.mobilesalescore.modulos.cliente.interfaces.ClienteClickListener

import kotlinx.android.synthetic.main.app_bar_main.*

class ClientesFragment : Fragment(),
    ClienteClickListener {

    private lateinit var recycler : RecyclerView
    private lateinit var clientesViewModel: ClientesViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        clientesViewModel = ViewModelProviders.of(this,
            ClientesViewModelFactory(
                context!!,
                this
            )
        ).get(ClientesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_clientes, container, false)
        recycler = root.findViewById(R.id.clientes_recycler_clientes)

        val title: TextView     = activity!!.main_toolbar_label
        val subTitle: TextView  = activity!!.main_toolbar_sublabel

        clientesViewModel.recycler.observe(this, Observer {
            recycler.adapter = it
            recycler.layoutManager = LinearLayoutManager(context)
        })

        clientesViewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        clientesViewModel.textSubtitle.observe(this, Observer {
            subTitle.text = it
        })
        setHasOptionsMenu(true)
        return root
    }

    override fun onResume() {
        super.onResume()
        clientesViewModel.refreshAdapter()
    }

    override fun onClienteClickOptions(view: View, position: Int) {
        clientesViewModel.mostrarPopUp(view, position)
    }

    override fun onClienteSelectOptions(cliente: Cliente) {
        Toast.makeText(context!!, "teste "+cliente.nomCli, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_basic, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menu_adicionar -> {
            this.findNavController().navigate(R.id.action_nav_clientes_to_nav_clientes_insert)
            true
        }
        R.id.menu_sincronizar ->{
            clientesViewModel.mostrarConfirmacaoSincronizacao()
            true
        }
        else -> super.onOptionsItemSelected(item)

    }

}