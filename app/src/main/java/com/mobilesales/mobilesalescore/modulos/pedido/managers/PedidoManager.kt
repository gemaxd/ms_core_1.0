package com.mobilesales.mobilesalescore.modulos.pedido.managers

import android.content.Context
import android.widget.Toast
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.models.enum.EnumPedidoStatus
import com.mobilesales.mobilesalescore.models.enum.EnumPedidoTipo
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import java.util.*

class PedidoManager() {

    fun gerarPedidoNovo(int : Int, ctx : Context) : Pedido {
        var ped = Pedido()
        removerStatusPedidoAtivo(ctx)

        ped.referenceCode        = UUID.randomUUID().toString()
        ped.codCliente           = 1
        ped.codCondicaoPagamento = "2"
        ped.codRepresentante     = 3
        ped.datEmissao           = Date().time
        ped.datPrevisao          = Date().time
        ped.dataAtualizacao      = Date().time
        ped.observacao           = "exemplo"
        ped.perComissao          = 0.0F
        ped.perIcmsSubstituido   = 0.0F
        ped.perIpi               = 0.0F
        ped.quantidade_itens     = 0
        ped.rowDel               = 0
        ped.sitPedido            = EnumPedidoStatus.ABERTO.toString()
        ped.tipPedido            = EnumPedidoTipo.VENDA_NORMAL.toString()
        ped.valBruto             = 0.0F
        ped.valComissao          = 0.0F
        ped.valIpi               = 0.0F
        ped.valTransporte        = 0.0F
        ped.ordemCompra          = "123456"
        ped.valIcmsSubstituido   = 0.0F
        ped.valLiquido           = 0.0F * int
        ped.clienteNome          = "CLIENTE "+int

        return ped
    }

    fun removerStatusPedidoAtivo(ctx : Context){
        var db      = AppDatabase.getAppDatabase(ctx)
        var lista   = db.pedidoDao().getAll()

        lista.forEach{
            it.pedidoAtivo = "N"
            db.pedidoDao().update(it)
        }

    }

}