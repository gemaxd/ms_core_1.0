package com.mobilesales.mobilesalescore.ui.sincronizacao

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilesales.mobilesalescore.ui.gallery.SairViewModel
import com.mobilesales.mobilesalescore.ui.gallery.SincronizacaoViewModel


class SincronizacaoViewModelFactory(private val context : Context) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SincronizacaoViewModel(context) as T
    }
}