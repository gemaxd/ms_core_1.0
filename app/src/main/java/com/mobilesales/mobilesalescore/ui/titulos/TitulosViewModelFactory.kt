package com.mobilesales.mobilesalescore.ui.titulos

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.TitulosItemClickListener
import com.mobilesales.mobilesalescore.ui.gallery.TitulosViewModel

class TitulosViewModelFactory(private val context : Context, private val listener : TitulosItemClickListener) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TitulosViewModel(context, listener) as T
    }
}