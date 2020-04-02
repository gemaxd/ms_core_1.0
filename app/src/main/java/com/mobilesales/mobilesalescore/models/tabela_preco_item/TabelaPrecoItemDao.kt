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
import com.mobilesales.mobilesalescore.models.tabela_preco_item.TabelaPrecoItem

@Dao
interface TabelaPrecoItemDao {
    @Query("SELECT * FROM tabelaprecoitem")
    fun getAll(): List<TabelaPrecoItem>

    @Query("SELECT * FROM tabelaprecoitem WHERE erpId IN (:tabelaprecoitemIds)")
    fun loadAllByIds(tabelaprecoitemIds: IntArray): List<TabelaPrecoItem>

    /*
    @Query("SELECT * FROM tabelaprecoitem WHERE nome_cliente LIKE :first LIMIT 1")
    fun findByName(first: String): Cliente
    */

    @Insert
    fun insertAll(vararg tabelaPrecoItems: TabelaPrecoItem)

    @Delete
    fun delete(tabelaPrecoItem: TabelaPrecoItem)
}