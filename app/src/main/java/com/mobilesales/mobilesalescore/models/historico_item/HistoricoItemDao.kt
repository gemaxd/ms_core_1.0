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
import com.mobilesales.mobilesalescore.models.historico_item.HistoricoItem

@Dao
interface HistoricoItemDao {
    @Query("SELECT * FROM historicoitem")
    fun getAll(): List<HistoricoItem>

    @Query("SELECT * FROM historicoitem WHERE erpId IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<HistoricoItem>

    /*@Query("SELECT * FROM historicoitem WHERE nome_cliente LIKE :first LIMIT 1")
    fun findByName(first: String): Cliente*/

    @Insert
    fun insertAll(vararg historicosItens: HistoricoItem)

    @Delete
    fun delete(historicoItem: HistoricoItem)
}