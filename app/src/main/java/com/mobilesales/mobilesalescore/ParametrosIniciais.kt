package com.mobilesales.mobilesalescore

import android.content.Context
import com.mobilesales.mobilesalescore.models.pedido.CondicaoPagamento
import com.mobilesales.mobilesalescore.models.pedido.TipoPedido
import com.mobilesales.mobilesalescore.models.pedido.Transportadora
import com.mobilesales.mobilesalescore.models.pedido_item.PedidoItem
import com.mobilesales.mobilesalescore.models.pedido_item.Produto
import java.util.*
import kotlin.collections.ArrayList

class ParametrosIniciais {

    lateinit var db : AppDatabase

    fun inicializarPreparacoes(ctx : Context){
        db = AppDatabase.getAppDatabase(ctx)

        prepararTiposPedido()
        prepararCondicoes()
        prepararTransportadoras()
        prepararItens()
        prepararProdutos()
    }



    fun prepararProdutos(){
        db.produtoDao().deleteAll()

        var pro = Produto()
        pro.referenceCode   = UUID.randomUUID().toString()
        pro.codProduto      = "0001"
        pro.descProduto     = "PRODUTO 0001 - Testes"
        db.produtoDao().insertAll(pro)

        var pro2 = Produto()
        pro2.referenceCode  = UUID.randomUUID().toString()
        pro2.codProduto     = "0002"
        pro2.descProduto    = "PRODUTO 0002 - Testes"
        db.produtoDao().insertAll(pro2)

        var pro3 = Produto()
        pro3.referenceCode  = UUID.randomUUID().toString()
        pro3.codProduto     = "0003"
        pro3.descProduto    = "PRODUTO 0003 - Testes"
        db.produtoDao().insertAll(pro3)

        var pro4 = Produto()
        pro4.referenceCode  = UUID.randomUUID().toString()
        pro4.codProduto     = "0004"
        pro4.descProduto    = "PRODUTO 0004 - Testes"
        db.produtoDao().insertAll(pro4)

        var pro5 = Produto()
        pro5.referenceCode  = UUID.randomUUID().toString()
        pro5.codProduto     = "0005"
        pro5.descProduto    = "PRODUTO 0005 - Testes"
        db.produtoDao().insertAll(pro5)
    }



    fun prepararItens(){
        db.pedidoItemDao().deleteAll()

        var item = PedidoItem()
        item.referenceCode = UUID.randomUUID().toString()
        db.pedidoItemDao().insertAll(item)

        var item2 = PedidoItem()
        item2.referenceCode = UUID.randomUUID().toString()
        db.pedidoItemDao().insertAll(item2)

        var item3 = PedidoItem()
        item3.referenceCode = UUID.randomUUID().toString()
        db.pedidoItemDao().insertAll(item3)

        var item4 = PedidoItem()
        item4.referenceCode = UUID.randomUUID().toString()
        db.pedidoItemDao().insertAll(item4)

        var item5 = PedidoItem()
        item5.referenceCode = UUID.randomUUID().toString()
        db.pedidoItemDao().insertAll(item5)
    }



    fun prepararTiposPedido(){
        var tipos : MutableList<TipoPedido> = ArrayList()
        db.tipoPedidoDao().deleteAll()

        var tp = TipoPedido()
        tp.referenceCode = UUID.randomUUID().toString()
        tp.nomTipoPedido = "Venda Normal"
        tp.codTipoPedido = "1"
        tipos.add(tp)

        var tp2 = TipoPedido()
        tp2.referenceCode = UUID.randomUUID().toString()
        tp2.nomTipoPedido = "Amostra"
        tp2.codTipoPedido = "2"
        tipos.add(tp2)

        var tp3 = TipoPedido()
        tp3.referenceCode = UUID.randomUUID().toString()
        tp3.nomTipoPedido = "Devolução"
        tp3.codTipoPedido = "3"
        tipos.add(tp3)

        var tp4 = TipoPedido()
        tp4.referenceCode = UUID.randomUUID().toString()
        tp4.nomTipoPedido = "Orçamento"
        tp4.codTipoPedido = "4"
        tipos.add(tp4)

        db.tipoPedidoDao().upsertAll(tipos)
    }





    fun prepararCondicoes(){
        var condicoes : MutableList<CondicaoPagamento> = ArrayList()
        db.condicaoPagamentoDao().deleteAll()

        var cp = CondicaoPagamento()
        cp.referenceCode = UUID.randomUUID().toString()
        cp.nomCondicaoPagamento = "À vista"
        cp.codCondicaoPagamento = "1"
        cp.percDescontoAcrescimo = -2.0
        condicoes.add(cp)

        var cp2 = CondicaoPagamento()
        cp2.referenceCode = UUID.randomUUID().toString()
        cp2.nomCondicaoPagamento = "À prazo"
        cp2.codCondicaoPagamento = "2"
        cp2.percDescontoAcrescimo = 0.0
        condicoes.add(cp2)

        var cp3 = CondicaoPagamento()
        cp3.referenceCode = UUID.randomUUID().toString()
        cp3.nomCondicaoPagamento = "60 dias"
        cp3.codCondicaoPagamento = "3"
        cp3.percDescontoAcrescimo = 2.0
        condicoes.add(cp3)

        db.condicaoPagamentoDao().upsertAll(condicoes)
    }





    fun prepararTransportadoras(){
        var transportadoras : MutableList<Transportadora> = ArrayList()
        db.transportadoraDao().deleteAll()

        var transportadora = Transportadora()
        transportadora.referenceCode = UUID.randomUUID().toString()
        transportadora.nomeTransportadora = "TRA - 001"
        transportadora.codTransportadora = "1"
        transportadoras.add(transportadora)

        var transportadora2 = Transportadora()
        transportadora2.referenceCode = UUID.randomUUID().toString()
        transportadora2.nomeTransportadora = "TRA - 002"
        transportadora2.codTransportadora = "2"
        transportadoras.add(transportadora2)

        var transportadora3 = Transportadora()
        transportadora3.referenceCode = UUID.randomUUID().toString()
        transportadora3.nomeTransportadora = "TRA - 003"
        transportadora3.codTransportadora = "3"
        transportadoras.add(transportadora3)

        db.transportadoraDao().upsertAll(transportadoras)
    }

}