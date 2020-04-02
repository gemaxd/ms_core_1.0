package com.mobilesales.mobilesalescore.ui.produtos

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.ProdutosItemClickListener
import com.mobilesales.mobilesalescore.ui.gallery.ProdutosViewModel


class ProdutosViewModelFactory(private val context : Context, private val listener : ProdutosItemClickListener) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProdutosViewModel(context, listener) as T
    }
}