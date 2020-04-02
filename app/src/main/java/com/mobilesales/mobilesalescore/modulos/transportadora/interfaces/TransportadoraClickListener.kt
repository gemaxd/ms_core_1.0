/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/10/19 2:57 PM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/10/19 2:57 PM
 -------------------------------------------------------------------------------------------------*/
package com.mobilesales.mobilesalescore.modulos.transportadora.interfaces

import com.mobilesales.mobilesalescore.models.pedido.Transportadora

interface TransportadoraClickListener {
    fun onTransportadorsSelect(transportadora: Transportadora)
}