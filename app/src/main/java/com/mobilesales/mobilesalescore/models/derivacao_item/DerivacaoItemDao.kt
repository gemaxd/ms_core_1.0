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
import com.mobilesales.mobilesalescore.models.derivacao_item.DerivacaoItem

@Dao
interface DerivacaoItemDao {
    @Query("SELECT * FROM derivacaoitem")
    fun getAll(): List<DerivacaoItem>

    @Query("SELECT * FROM derivacaoitem WHERE erpId IN (:derivacoesItensIds)")
    fun loadAllByIds(derivacoesItensIds: IntArray): List<DerivacaoItem>

    /*@Query("SELECT * FROM cliente WHERE nome_cliente LIKE :first LIMIT 1")
    fun findByName(first: String): Cliente*/

    @Insert
    fun insertAll(vararg derivacoesItens: DerivacaoItem)

    @Delete
    fun delete(derivacaoItem: DerivacaoItem)
}