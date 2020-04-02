package com.mobilesales.mobilesalescore.models.base

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.mobilesales.mobilesalescore.models.base.BaseObject
import org.jetbrains.annotations.NotNull

/**
 * Criado por Jessé Manarim em 2019-09-25
 *
 * MOBILE SALES
 * todos os direitos reservados
 */
abstract class CondicaoPagamentoBase : BaseObject(){

    @PrimaryKey
    var referenceCode: String = ""

    @NotNull
    @ColumnInfo(name = "cod_condicao_pagamento")
    var codCondicaoPagamento: String = ""

    @NotNull
    @ColumnInfo(name = "nom_condicao_pagamento")
    var nomCondicaoPagamento: String = ""

    @NotNull
    @ColumnInfo(name = "perc_desconto_acrescimo")
    var percDescontoAcrescimo: Double = 0.0

}