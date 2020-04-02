/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/12/19 11:37 AM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/12/19 11:00 AM
 -------------------------------------------------------------------------------------------------*/

package com.mobilesales.mobilesalescore.models.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mobilesales.mobilesalescore.models.base.BaseObject
import org.jetbrains.annotations.NotNull

abstract class ClienteBase : BaseObject() {

    @PrimaryKey(autoGenerate = true)
    var erpId: Long = 0

    @NotNull
    @ColumnInfo(name = "nome_cliente")
    var nomCli: String = ""

    @ColumnInfo(name = "nome_fantasia")
    var nomFan: String = ""

    @ColumnInfo(name = "cliente_cpf_cnpj")
    var cliCpfCnpj: String = ""

    @ColumnInfo(name = "tipo_cliente")
    var tipCli: String = ""

    @ColumnInfo(name = "tipo_empresa")
    var tipEmp: String = ""

    @ColumnInfo(name = "ramo_atividade")
    var codRam: String = ""

    @ColumnInfo(name = "cliente_contribui_icms")
    var cliContrib: String = ""

    @ColumnInfo(name = "cliente_inscricao_estadual")
    var cliInscrEst: String = ""

    @ColumnInfo(name = "cliente_inscricao_municipal")
    var cliInscrMun: String = ""

    @ColumnInfo(name = "cliente_beneficio_fiscal")
    var cliBeneFis: String = ""

    @ColumnInfo(name = "cliente_codigo_suframa")
    var cliCodSuframa: String = ""

    @ColumnInfo(name = "cliente_tributa_icms")
    var cliTribIcms: String = ""

    @ColumnInfo(name = "cliente_tributa_ipi")
    var cliTribIpi: String = ""

    @ColumnInfo(name = "cliente_tributa_pis")
    var cliTribPis: String = ""

    @ColumnInfo(name = "cliente_tributa_cofins")
    var cliTribCofins: String = ""

    @ColumnInfo(name = "cliente_retencao_irrf")
    var cliRetIRRF: String = ""

    @ColumnInfo(name = "cliente_endereco")
    var cliEnd: String = ""

}

