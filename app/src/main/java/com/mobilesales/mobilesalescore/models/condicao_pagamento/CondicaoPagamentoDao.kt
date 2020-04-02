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
interface CondicaoPagamentoDao {
    @Query("SELECT * FROM condicaopagamento")
    fun getAll(): List<CondicaoPagamento>

    @Query("SELECT * FROM condicaopagamento WHERE cod_condicao_pagamento = :cod ")
    fun getById(cod: String): CondicaoPagamento

    @Query("SELECT * FROM condicaopagamento WHERE referenceCode IN (:refs)")
    fun loadAllByIds(refs: String): List<CondicaoPagamento>

    @Update
    fun update(vararg condicoes: CondicaoPagamento)

    @Delete
    fun delete(condicaoPagamento: CondicaoPagamento)

    @Query("DELETE FROM condicaopagamento ")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(obj: List<CondicaoPagamento>): List<Long>

    @Update
    fun updateAll(questions: List<CondicaoPagamento>)

    @Transaction
    fun upsertAll(objList: List<CondicaoPagamento>) {
        val insertResults = insertAll(objList)
        val updateList = ArrayList<CondicaoPagamento>()

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