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
import com.mobilesales.mobilesalescore.models.nota.Nota

@Dao
interface NotaDao {
    @Query("SELECT * FROM nota")
    fun getAll(): List<Nota>

    @Query("SELECT * FROM nota WHERE erpId IN (:notasIds)")
    fun loadAllByIds(notasIds: IntArray): List<Nota>

    /*@Query("SELECT * FROM nota WHERE nome_cliente LIKE :first LIMIT 1")
    fun findByName(first: String): Cliente*/

    @Insert
    fun insertAll(vararg notas: Nota)

    @Delete
    fun delete(nota: Nota)
}