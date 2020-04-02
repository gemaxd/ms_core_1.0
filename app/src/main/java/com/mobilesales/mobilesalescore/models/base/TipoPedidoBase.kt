package com.mobilesales.mobilesalescore.models.base

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.mobilesales.mobilesalescore.models.base.BaseObject
import org.jetbrains.annotations.NotNull

/**
 * Criado por Jessé Manarim em 2019-09-25
 *
 * MOBILE SALES
 * todos os direitos reservados
 */
abstract class TipoPedidoBase : BaseObject(){

    @PrimaryKey
    var referenceCode: String = ""

    @NotNull
    @ColumnInfo(name = "nom_tipo_pedido")
    var nomTipoPedido: String = ""

    @NotNull
    @ColumnInfo(name = "cod_tipo_pedido")
    var codTipoPedido: String = ""

}