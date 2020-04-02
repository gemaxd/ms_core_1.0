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
import com.mobilesales.mobilesalescore.models.nota_item.NotaItem

@Dao
interface NotaItemDao {
    @Query("SELECT * FROM notaitem")
    fun getAll(): List<NotaItem>

    @Query("SELECT * FROM notaitem WHERE erpId IN (:notaItensIds)")
    fun loadAllByIds(notaItensIds: IntArray): List<NotaItem>

    /*@Query("SELECT * FROM cliente WHERE nome_cliente LIKE :first LIMIT 1")
    fun findByName(first: String): Cliente*/

    @Insert
    fun insertAll(vararg notaItens: NotaItem)

    @Delete
    fun delete(notaItem: NotaItem)

}