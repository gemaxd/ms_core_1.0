package com.mobilesales.mobilesalescore.models.enum

enum class EnumPedidoEstado {

    PEDIDO_ESTADO_NOVO {
        fun getPedidoEstado() = PEDIDO_ESTADO_NOVO
    },

    PEDIDO_ESTADO_EXISTENTE {
        fun getPedidoEstado() = PEDIDO_ESTADO_EXISTENTE
    }

}