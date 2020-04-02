/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/11/19 5:34 PM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/10/19 3:05 PM
 -------------------------------------------------------------------------------------------------*/

package com.mobilesales.mobilesalescore.ui.clientes.interfaces

import android.view.View
import com.mobilesales.mobilesalescore.models.pedido_item.Produto

interface ProdutosItemClickListener {
    fun onProdutoClickOptions(view : View, position : Int)
    fun onProdutoClickQuickAdd(view : View, pro : Produto)
}
