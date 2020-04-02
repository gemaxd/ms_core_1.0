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
abstract class PedidoItemBase : BaseObject(){

    @PrimaryKey
    var referenceCode: String = ""

    @NotNull
    @ColumnInfo(name = "descricao_produto")
    var descProduto: String = "Produto Teste"

    @NotNull
    @ColumnInfo(name = "dat_emissao")
    var datEmissao: Long = 0

    @NotNull
    @ColumnInfo(name = "dat_previsao")
    var datPrevisao: Long = 0

    @NotNull
    @ColumnInfo(name = "observacao")
    var observacao: Long = 0

    @NotNull
    @ColumnInfo(name = "cod_cliente")
    var codCliente: Long = 0

    @NotNull
    @ColumnInfo(name = "cod_produto")
    var codProduto: String = ""

    @NotNull
    @ColumnInfo(name = "cod_representante")
    var codRepresentante: Long = 0

    @NotNull
    @ColumnInfo(name = "cod_condicao_pagamento")
    var codCondicaoPagamento: Long = 0

    /*******************************************
     **********  Valores em R$ $$$,$$ **********
     ******************************************/

    @NotNull
    @ColumnInfo(name = "val_unitario")
    var valUnitario: Float = 0.0F

    @NotNull
    @ColumnInfo(name = "val_bruto")
    var valBruto: Float = 0.0F

    @NotNull
    @ColumnInfo(name = "val_liquido")
    var valLiquido: Float = 0.0F

    @NotNull
    @ColumnInfo(name = "val_ipi")
    var valIpi: Float = 0.0F

    @NotNull
    @ColumnInfo(name = "val_icms_substituido")
    var valIcmsSubstituido: Float = 0.0F

    @NotNull
    @ColumnInfo(name = "val_comissao")
    var valComissao: Float = 0.0F

    /*******************************************
     **************  Percentuais ***************
     ******************************************/

    @NotNull
    @ColumnInfo(name = "per_ipi")
    var perIpi: Float = 0.0F

    @NotNull
    @ColumnInfo(name = "per_icms_substituido")
    var perIcmsSubstituido: Float = 0.0F

    @NotNull
    @ColumnInfo(name = "per_comissao")
    var perComissao: Float = 0.0F
}