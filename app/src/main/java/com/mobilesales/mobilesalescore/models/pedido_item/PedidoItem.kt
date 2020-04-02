package com.mobilesales.mobilesalescore.models.pedido_item

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.mobilesales.mobilesalescore.models.base.PedidoItemBase

@Entity
class PedidoItem : PedidoItemBase() {

    @ColumnInfo(name = "teste")
    var teste : String = ""

    @ColumnInfo(name = "pedido_ref_code")
    var pedidoReferenceCode : String = ""
}