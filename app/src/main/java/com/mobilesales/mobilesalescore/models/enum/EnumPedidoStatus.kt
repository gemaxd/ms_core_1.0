package com.mobilesales.mobilesalescore.models.enum

enum class EnumPedidoStatus {

    ABERTO {
        fun getPedidoStatus() = ABERTO
    },

    CANCELADO {
        fun getPedidoStatus() = CANCELADO
    },

    PENDENTE {
        fun getPedidoStatus() = PENDENTE
    },

    BLOQUEADO {
        fun getPedidoStatus() = BLOQUEADO
    },

    FINALIZADO {
        fun getPedidoStatus() = FINALIZADO
    },

    TRANSMITIR {
        fun getPedidoStatus() = TRANSMITIR
    },

    TRANSMITIDO {
        fun getPedidoStatus() = TRANSMITIDO
    }

}