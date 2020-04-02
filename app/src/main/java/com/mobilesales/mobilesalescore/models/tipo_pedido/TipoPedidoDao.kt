/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/12/19 11:00 AM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/12/19 11:00 AM
 -------------------------------------------------------------------------------------------------*/

package com.mobilesales.mobilesalescore.models.user

import androidx.room.*
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import com.mobilesales.mobilesalescore.models.pedido.CondicaoPagamento
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import com.mobilesales.mobilesalescore.models.pedido.TipoPedido
import com.mobilesales.mobilesalescore.models.pedido.Transportadora

@Dao
interface TipoPedidoDao {
    @Query("SELECT * FROM tipopedido")
    fun getAll(): List<TipoPedido>

    @Query("SELECT * FROM tipopedido WHERE referenceCode = :reference ")
    fun getById(reference: String): TipoPedido

    @Query("SELECT * FROM tipopedido WHERE referenceCode IN (:refs)")
    fun loadAllByIds(refs: String): List<TipoPedido>

    @Insert
    fun insertAll(vararg tipos: TipoPedido)

    @Update
    fun update(vararg tipos: TipoPedido)

    @Delete
    fun delete(tipos: TipoPedido)

    @Query("DELETE FROM tipopedido ")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(obj: List<TipoPedido>): List<Long>

    @Update
    fun updateAll(questions: List<TipoPedido>)

    @Transaction
    fun upsertAll(objList: List<TipoPedido>) {
        val insertResults = insertAll(objList)
        val updateList = ArrayList<TipoPedido>()

        for (i in insertResults.indices) {
            if (insertResults[i] == -1L) {
                updateList.add(objList[i])
            }
        }

        if (!updateList.isEmpty()) {
            updateAll(updateList)
        }
    }
}