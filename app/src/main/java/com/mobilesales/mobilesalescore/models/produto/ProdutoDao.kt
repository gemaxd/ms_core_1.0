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
import com.mobilesales.mobilesalescore.models.pedido_item.Produto

@Dao
interface ProdutoDao {
    @Query("SELECT * FROM produto")
    fun getAll(): List<Produto>

    @Query("SELECT * FROM pedidoitem WHERE referenceCode IN (:pedidoItensIds)")
    fun loadAllByIds(pedidoItensIds: String): List<PedidoItem>

    @Query("SELECT * FROM produto WHERE pedido_ref_code LIKE :pedRef")
    fun loadAllByRef(pedRef: String):  List<Produto>

    @Insert
    fun insertAll(vararg produtos: Produto)

    @Delete
    fun delete(produto: Produto)

    @Query("DELETE FROM produto ")
    fun deleteAll()

}