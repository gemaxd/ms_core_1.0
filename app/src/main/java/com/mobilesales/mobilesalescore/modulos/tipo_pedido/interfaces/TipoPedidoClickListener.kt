/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/10/19 2:57 PM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/10/19 2:57 PM
 -------------------------------------------------------------------------------------------------*/
package com.mobilesales.mobilesalescore.modulos.tipo_pedido.interfaces

import com.mobilesales.mobilesalescore.models.pedido.TipoPedido

interface TipoPedidoClickListener {
    fun onTipoPedidoSelectOptions(tipoPed : TipoPedido)
}