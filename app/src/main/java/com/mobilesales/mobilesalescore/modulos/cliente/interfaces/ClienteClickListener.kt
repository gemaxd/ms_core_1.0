/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/10/19 2:57 PM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/10/19 2:57 PM
 -------------------------------------------------------------------------------------------------*/

package com.mobilesales.mobilesalescore.modulos.cliente.interfaces

import android.view.View
import com.mobilesales.mobilesalescore.models.cliente.Cliente

interface ClienteClickListener {
    fun onClienteClickOptions(view : View, position : Int)
    fun onClienteSelectOptions(cliente : Cliente)
}