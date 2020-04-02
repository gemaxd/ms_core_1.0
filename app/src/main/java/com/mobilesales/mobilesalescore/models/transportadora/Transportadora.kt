package com.mobilesales.mobilesalescore.models.pedido

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.mobilesales.mobilesalescore.models.base.PedidoBase
import com.mobilesales.mobilesalescore.models.base.TransportadoraBase

/**
 * Criado por Jessé Manarim em 2019-09-25
 *
 * MOBILE SALES
 * todos os direitos reservados
 */
@Entity
class Transportadora : TransportadoraBase(){

    @ColumnInfo(name = "teste")
    var teste : String = ""

}