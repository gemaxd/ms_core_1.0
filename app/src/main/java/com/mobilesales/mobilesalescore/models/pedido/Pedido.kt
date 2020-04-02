package com.mobilesales.mobilesalescore.models.pedido

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.mobilesales.mobilesalescore.models.base.PedidoBase

/**
 * Criado por Jessé Manarim em 2019-09-25
 *
 * MOBILE SALES
 * todos os direitos reservados
 */
@Entity
class Pedido : PedidoBase(){

    @ColumnInfo(name = "cliente_nome")
    var clienteNome : String = ""

    @ColumnInfo(name = "ordem_compra")
    var ordemCompra : String = ""

    @ColumnInfo(name = "transportadora")
    var transportadora : String = ""

    @ColumnInfo(name = "modalidade")
    var modalidade : String = ""

    @ColumnInfo(name = "pedido_ativo")
    var pedidoAtivo : String = "A"

}