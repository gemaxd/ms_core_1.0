package com.mobilesales.mobilesalescore.ui.catalogo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilesales.mobilesalescore.ui.gallery.CatalogoViewModel
import com.mobilesales.mobilesalescore.ui.gallery.SairViewModel


class CatalogoViewModelFactory(private val context : Context) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatalogoViewModel(context) as T
    }
}