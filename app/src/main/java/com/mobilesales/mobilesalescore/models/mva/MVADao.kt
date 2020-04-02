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
import com.mobilesales.mobilesalescore.models.mva.MVA

@Dao
interface MVADao {
    @Query("SELECT * FROM mva")
    fun getAll(): List<MVA>

    @Query("SELECT * FROM mva WHERE erpId IN (:mvas)")
    fun loadAllByIds(mvas: IntArray): List<MVA>

    /*
    @Query("SELECT * FROM cliente WHERE nome_cliente LIKE :first LIMIT 1")
    fun findByName(first: String): Cliente
    */

    @Insert
    fun insertAll(vararg mvas: MVA)

    @Delete
    fun delete(mva: MVA)
}