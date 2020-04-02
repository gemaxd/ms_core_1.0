/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/11/19 5:34 PM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/10/19 3:05 PM
 -------------------------------------------------------------------------------------------------*/

package com.mobilesales.mobilesalescore.ui.clientes.interfaces

import android.view.View
import com.mobilesales.mobilesalescore.models.pedido.Pedido

interface PedidoClickListener {
    fun onPedidoClickOptions(view : View, position : Int)
    fun onAbrirCabecalhoPedido(pedido : Pedido)
}