package com.mobilesales.mobilesalescore.modulos.pedido.views.fragments.pedido_cabecalho

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import com.mobilesales.mobilesalescore.models.enum.EnumPedidoStatus
import com.mobilesales.mobilesalescore.models.pedido.CondicaoPagamento
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import com.mobilesales.mobilesalescore.models.pedido.TipoPedido
import com.mobilesales.mobilesalescore.models.pedido.Transportadora
import com.mobilesales.mobilesalescore.modulos.cliente.interfaces.ClienteClickListener
import com.mobilesales.mobilesalescore.modulos.cliente.views.dialog.ClienteDialogSelect
import com.mobilesales.mobilesalescore.modulos.condicao_pagamento.interfaces.CondicaoPagamentoClickListener
import com.mobilesales.mobilesalescore.modulos.condicao_pagamento.views.dialog.CondicaoPagamentoDialogSelect
import com.mobilesales.mobilesalescore.modulos.tipo_pedido.interfaces.TipoPedidoClickListener
import com.mobilesales.mobilesalescore.modulos.tipo_pedido.views.dialog.TipoPedidoDialogSelect
import com.mobilesales.mobilesalescore.modulos.transportadora.interfaces.TransportadoraClickListener
import com.mobilesales.mobilesalescore.modulos.transportadora.views.dialog.TransportadoraDialogSelect
import kotlinx.android.synthetic.main.fragment_pedido_cabecalho.*

private const val ESTADO_PEDIDO     = "PEDIDO_ESTADO"
private const val PEDIDO_NOVO       = "PEDIDO_ESTADO_NOVO"
private const val PEDIDO_REFERENCE  = "PEDIDO_REFERENCE"

class PedidoCabecalhoFragment : Fragment(), ClienteClickListener, TipoPedidoClickListener, TransportadoraClickListener, CondicaoPagamentoClickListener {

    // TODO: Rename and change types of parameters
    private  var estado:        String? = null
    private  var pedidoRef:     String? = null
    lateinit var pedido:        Pedido
    lateinit var db:            AppDatabase
    lateinit var teste:         String
    lateinit var dialogCliente: ClienteDialogSelect
    lateinit var dialogTipPed:  TipoPedidoDialogSelect
    lateinit var dialogTransp:  TransportadoraDialogSelect
    lateinit var dialogCondicao:CondicaoPagamentoDialogSelect
    lateinit var condicaoPag:   CondicaoPagamento

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            estado      = it.getString(ESTADO_PEDIDO)
            pedidoRef   = it.getString(PEDIDO_REFERENCE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_pedido_cabecalho, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initListeners()
        navController = Navigation.findNavController(view)
        if(estado == PEDIDO_NOVO){
            openClienteDialog()
        }else{
            pedido = db.pedidoDao().getById(pedidoRef!!)
            refreshViews()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_basic, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menu_adicionar -> {
            navController!!.navigate(R.id.action_nav_clientes_to_nav_clientes_insert)
            true
        }
        R.id.menu_sincronizar ->{
            Toast.makeText(context!!, "Ação de sincronização", Toast.LENGTH_SHORT).show()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun newInstance(estado: String, reference : String) =
            PedidoCabecalhoFragment().apply {
                arguments = Bundle().apply {
                    putString(ESTADO_PEDIDO, estado)
                    putString(PEDIDO_REFERENCE, reference)
                }
            }
    }

    fun fecharPedido(){
        pedido.sitPedido = EnumPedidoStatus.TRANSMITIR.toString()
        db.pedidoDao().update(pedido)
        navController.popBackStack()
    }

    fun reabrirPedido(){
        pedido.sitPedido = EnumPedidoStatus.ABERTO.toString()
        db.pedidoDao().update(pedido)
        navController.popBackStack()
    }

    fun adicionarItens(){
        Toast.makeText(context!!, "teste para adição de item", Toast.LENGTH_SHORT).show()
    }

    fun openClienteDialog(){
        dialogCliente = ClienteDialogSelect.newInstance(this)
        dialogCliente.show(fragmentManager!!, "dialogCliente")
    }

    fun openTipoPedidoDialog(){
        dialogTipPed = TipoPedidoDialogSelect.newInstance(this)
        dialogTipPed.show(fragmentManager!!, "dialogTipoPedido")
    }

    fun openTransportadoraDialog(){
        dialogTransp = TransportadoraDialogSelect.newInstance(this)
        dialogTransp.show(fragmentManager!!, "dialogTransportadora")
    }

    fun openCondicaoPagamento(){
        dialogCondicao = CondicaoPagamentoDialogSelect.newInstance(this)
        dialogCondicao.show(fragmentManager!!, "dialogCondicaoPagamento")
    }

    fun refreshViews(){
        condicaoPag = db.condicaoPagamentoDao().getById(pedido.codCondicaoPagamento)

        ped_cabecalho_tipo_ped.setText(pedido.tipPedido)
        ped_cabecalho_nome_cliente.setText(pedido.clienteNome)
        ped_cabecalho_condicao_pag.setText(condicaoPag.nomCondicaoPagamento)
        ped_cabecalho_ordem_compra.setText(pedido.ordemCompra)
        ped_cabecalho_transportadora.setText(pedido.transportadora)
        ped_cabecalho_modalidade.setText(pedido.modalidade)
        ped_cabecalho_observacoes.setText(pedido.observacao)
        ped_cabecalho_modalidade.setText(pedido.modalidade)
    }

    override fun onClienteClickOptions(view: View, position: Int) {
        Toast.makeText(context!!, "teste onClienteClickOptions ", Toast.LENGTH_SHORT).show()
    }

    fun initData(){
        db          = AppDatabase.getAppDatabase(context!!)
        pedido      = db.pedidoDao().getById(pedidoRef!!)
    }

    fun initListeners(){
        ped_cabecalho_tipo_ped.setOnClickListener {
            openTipoPedidoDialog()
        }
        ped_cabecalho_nome_cliente.setOnClickListener{
            openClienteDialog()
        }
        ped_cabecalho_condicao_pag.setOnClickListener{
            openCondicaoPagamento()
        }
        ped_cabecalho_transportadora.setOnClickListener{
            openTransportadoraDialog()
        }
        ped_cabecalho_modalidade.setOnClickListener{
            abrirDialog()
        }
        extendedFecharPedido.setOnClickListener {
            fecharPedido()
        }
        extendedAdicionarItem.setOnClickListener {
            navController.navigate(R.id.action_nav_pedido_to_nav_produtos)
        }
        extendedReabrirPedido.setOnClickListener {
            reabrirPedido()
        }
    }

    override fun onClienteSelectOptions(cliente: Cliente) {
        dialogCliente.dismiss()
        pedido.clienteNome = cliente.nomCli
        db.pedidoDao().update(pedido)
        refreshViews()
    }

    override fun onTipoPedidoSelectOptions(tipoPed: TipoPedido) {
        dialogTipPed.dismiss()
        pedido.tipPedido = tipoPed.nomTipoPedido
        db.pedidoDao().update(pedido)
        refreshViews()
    }

    override fun onTransportadorsSelect(transportadora: Transportadora) {
        dialogTransp.dismiss()
        pedido.transportadora = transportadora.nomeTransportadora
        db.pedidoDao().update(pedido)
        refreshViews()
    }

    override fun onCondicaoPagamentoSelect(condicaoPagamento: CondicaoPagamento) {
        dialogCondicao.dismiss()
        pedido.codCondicaoPagamento = condicaoPagamento.codCondicaoPagamento
        db.pedidoDao().update(pedido)
        refreshViews()
    }

    fun abrirDialog(){
        MaterialAlertDialogBuilder(context)
            .setTitle("Atenção")
            .setIcon(R.drawable.ic_clientes)
            .setCancelable(false)
            .setMessage("Deseja mesmo excluir o cliente ")
            .setPositiveButton("SIM, excluir") { dialog, which ->  }
            .setNegativeButton("NÃO") { dialog, which ->  }
            .show()
    }
}
