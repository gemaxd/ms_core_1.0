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

@Dao
interface BannerDao {
    @Query("SELECT * FROM cliente")
    fun getAll(): List<Cliente>

    @Query("SELECT * FROM cliente WHERE erpId IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Cliente>

    @Query("SELECT * FROM cliente WHERE nome_cliente LIKE :first LIMIT 1")
    fun findByName(first: String): Cliente

    @Insert
    fun insertAll(vararg clientes: Cliente)

    @Delete
    fun delete(cliente: Cliente)
}