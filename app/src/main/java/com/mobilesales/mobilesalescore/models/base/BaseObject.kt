package com.mobilesales.mobilesalescore.models.base

import android.text.format.DateUtils
import androidx.room.ColumnInfo
import org.jetbrains.annotations.NotNull

abstract class BaseObject {

    @NotNull
    @ColumnInfo(name = "rowdel")
    var rowDel: Long = 0

    @NotNull
    @ColumnInfo(name = "data_atualizacao")
    var dataAtualizacao: Long = DateUtils.DAY_IN_MILLIS
}