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
import com.mobilesales.mobilesalescore.models.historico.Historico

@Dao
interface HistoricoDao {
    @Query("SELECT * FROM historico")
    fun getAll(): List<Historico>

    @Query("SELECT * FROM historico WHERE erpId IN (:historicosIds)")
    fun loadAllByIds(historicosIds: IntArray): List<Historico>

    /*@Query("SELECT * FROM cliente WHERE nome_cliente LIKE :first LIMIT 1")
    fun findByName(first: String): Cliente*/

    @Insert
    fun insertAll(vararg historicos: Historico)

    @Delete
    fun delete(historico: Historico)
}