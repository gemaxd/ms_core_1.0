package com.mobilesales.mobilesalescore.models.enum

enum class EnumPedidoTipo {

    ORCAMENTO {
        fun getPedidoStatus() = ORCAMENTO
    },

    USO_CONSUMO {
        fun getPedidoStatus() = USO_CONSUMO
    },

    AMOSTRA {
        fun getPedidoStatus() = AMOSTRA
    },

    VENDA_NORMAL {
        fun getPedidoStatus() = VENDA_NORMAL
    },

    FINALIZADO {
        fun getPedidoStatus() = FINALIZADO
    }
    
}