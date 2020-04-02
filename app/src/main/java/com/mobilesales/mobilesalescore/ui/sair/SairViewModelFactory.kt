package com.mobilesales.mobilesalescore.ui.sair

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilesales.mobilesalescore.ui.gallery.SairViewModel


class SairViewModelFactory(private val context : Context) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SairViewModel(context) as T
    }
}