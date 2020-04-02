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
import com.mobilesales.mobilesalescore.models.pedido.Transportadora

@Dao
interface TransportadoraDao {
    @Query("SELECT * FROM transportadora")
    fun getAll(): List<Transportadora>

    @Query("SELECT * FROM transportadora WHERE referenceCode = :reference ")
    fun getById(reference: String): Transportadora

    @Query("SELECT * FROM transportadora WHERE referenceCode IN (:refs)")
    fun loadAllByIds(refs: String): List<Transportadora>

    @Insert
    fun insertAll(vararg transportadoras: Transportadora)

    @Update
    fun update(vararg transportadoras: Transportadora)

    @Delete
    fun delete(transportadora: Transportadora)

    @Query("DELETE FROM transportadora ")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(obj: List<Transportadora>): List<Long>

    @Update
    fun updateAll(questions: List<Transportadora>)

    @Transaction
    fun upsertAll(objList: List<Transportadora>) {
        val insertResults = insertAll(objList)
        val updateList = ArrayList<Transportadora>()

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