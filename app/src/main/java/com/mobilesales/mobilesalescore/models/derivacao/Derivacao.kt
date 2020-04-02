package com.mobilesales.mobilesalescore.models.derivacao

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.mobilesales.mobilesalescore.models.user.ClienteBase

/**
 * Criado por Jessé Manarim em 2019-09-25
 *
 * MOBILE SALES
 * todos os direitos reservados
 */
@Entity
class Derivacao : ClienteBase() {

    @ColumnInfo(name = "teste")
    var teste: String = ""

}