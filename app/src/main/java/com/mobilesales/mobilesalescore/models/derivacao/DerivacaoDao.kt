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
import com.mobilesales.mobilesalescore.models.derivacao.Derivacao

@Dao
interface DerivacaoDao {
    @Query("SELECT * FROM derivacao")
    fun getAll(): List<Cliente>

    @Query("SELECT * FROM derivacao WHERE erpId IN (:dericoesIds)")
    fun loadAllByIds(dericoesIds: IntArray): List<Derivacao>

    /*@Query("SELECT * FROM derivacao WHERE nome_cliente LIKE :first LIMIT 1")
    fun findByName(first: String): Cliente*/

    @Insert
    fun insertAll(vararg derivacao: Derivacao)

    @Delete
    fun delete(derivacao: Derivacao)
}