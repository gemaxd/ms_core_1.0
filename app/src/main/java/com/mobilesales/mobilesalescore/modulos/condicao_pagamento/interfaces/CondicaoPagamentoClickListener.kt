/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/10/19 2:57 PM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/10/19 2:57 PM
 -------------------------------------------------------------------------------------------------*/
package com.mobilesales.mobilesalescore.modulos.condicao_pagamento.interfaces

import com.mobilesales.mobilesalescore.models.pedido.CondicaoPagamento

interface CondicaoPagamentoClickListener {
    fun onCondicaoPagamentoSelect(condicaoPagamento: CondicaoPagamento)
}