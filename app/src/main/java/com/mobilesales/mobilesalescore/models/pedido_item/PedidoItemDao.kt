/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/12/19 11:00 AM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/12/19 11:00 AM
 -------------------------------------------------------------------------------------------------*/

package com.mobilesales.mobilesalescore.models.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import com.mobilesales.mobilesalescore.models.pedido_item.PedidoItem

@Dao
interface PedidoItemDao {
    @Query("SELECT * FROM pedidoitem")
    fun getAll(): List<PedidoItem>

    @Query("SELECT * FROM pedidoitem WHERE referenceCode IN (:pedidoItensIds)")
    fun loadAllByIds(pedidoItensIds: String): List<PedidoItem>

    @Query("SELECT * FROM pedidoitem WHERE pedido_ref_code LIKE :pedRef")
    fun loadAllByRef(pedRef: String):  List<PedidoItem>

    @Insert
    fun insertAll(vararg pedidoItens: PedidoItem)

    @Delete
    fun delete(pedidoItem: PedidoItem)

    @Query("DELETE FROM tipopedido ")
    fun deleteAll()

}