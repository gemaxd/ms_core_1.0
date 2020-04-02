/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/12/19 11:00 AM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/12/19 11:00 AM
 -------------------------------------------------------------------------------------------------*/

package com.mobilesales.mobilesalescore.models.user

import androidx.room.*
import com.mobilesales.mobilesalescore.models.pedido.Pedido

@Dao
interface PedidoDao {
    @Query("SELECT * FROM pedido")
    fun getAll(): List<Pedido>

    @Query("SELECT * FROM pedido WHERE pedido_ativo = 'A' ")
    fun getPedidoAtivo(): Pedido

    @Query("SELECT * FROM pedido WHERE referenceCode = :reference ")
    fun getById(reference: String): Pedido

    @Query("SELECT * FROM pedido WHERE referenceCode IN (:refs)")
    fun loadAllByIds(refs: String): List<Pedido>

    @Insert
    fun insertAll(vararg pedidos: Pedido)

    @Update
    fun update(vararg pedidos: Pedido)

    @Delete
    fun delete(pedido: Pedido)
}