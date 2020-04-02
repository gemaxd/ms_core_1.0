/*--------------------------------------------------------------------------------------------------
 -   Created by Jessé Manarim on 9/12/19 11:02 AM
 -   Copyright (c) 2019 . All rights reserved.
 -   Last modified 9/12/19 11:02 AM
 -------------------------------------------------------------------------------------------------*/

package com.mobilesales.mobilesalescore

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import com.mobilesales.mobilesalescore.models.pedido.CondicaoPagamento
import com.mobilesales.mobilesalescore.models.pedido.Pedido
import com.mobilesales.mobilesalescore.models.pedido.TipoPedido
import com.mobilesales.mobilesalescore.models.pedido.Transportadora
import com.mobilesales.mobilesalescore.models.pedido_item.PedidoItem
import com.mobilesales.mobilesalescore.models.pedido_item.Produto
import com.mobilesales.mobilesalescore.models.user.*

@Database(entities = arrayOf( Cliente::class
                            , Pedido::class, Transportadora::class
                            , CondicaoPagamento::class
                            , TipoPedido::class
                            , PedidoItem::class
                            , Produto::class), version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun pedidoDao(): PedidoDao
    abstract fun transportadoraDao(): TransportadoraDao
    abstract fun condicaoPagamentoDao(): CondicaoPagamentoDao
    abstract fun tipoPedidoDao(): TipoPedidoDao
    abstract fun pedidoItemDao(): PedidoItemDao
    abstract fun produtoDao(): ProdutoDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        @JvmStatic
        fun getAppDatabase(context: Context): AppDatabase {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase::class.java, "BASE_MSCORE")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
//                        .addMigrations(MIGRATION_1_2)
                    .build()


            }
            return INSTANCE as AppDatabase
        }


        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }


    }
}