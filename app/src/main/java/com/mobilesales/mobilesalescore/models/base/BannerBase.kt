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
abstract class BannerBase : BaseObject(){

    @PrimaryKey
    var referenceCode: String = ""

    @NotNull
    @ColumnInfo(name = "url_imagem")
    var urlImagem: String = ""

    @NotNull
    @ColumnInfo(name = "posicao")
    var posicao: String = ""

    @NotNull
    @ColumnInfo(name = "modulo")
    var modulo: String = ""

}