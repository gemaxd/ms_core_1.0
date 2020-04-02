package com.mobilesales.mobilesalescore.ui.gallery

import android.content.Context
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation.findNavController
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.ui.clientes.adapters.TitulosAdapter
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.TitulosItemClickListener

class TitulosViewModel(ctx: Context, listener : TitulosItemClickListener) : ViewModel() {

    var context : Context = ctx

    private val recycler_main = MutableLiveData<TitulosAdapter>().apply {
        value = TitulosAdapter(ctx, listener)
    }
    val recycler: LiveData<TitulosAdapter> = recycler_main

    private val _title = MutableLiveData<String>().apply {
        value = ctx.getString(R.string.menu_titulos)
    }
    val textTitle: LiveData<String> = _title

    private val _subtitle = MutableLiveData<String>().apply {
        value = ctx.getString(R.string.menu_titulos_sub)
    }
    val textSubtitle: LiveData<String> = _subtitle

    /**Popups*/
    fun mostrarPopUp(view : View, position : Int){
        val popup = PopupMenu(context, view)
        popup.inflate(R.menu.popup_menu_clientes)
        popup.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                when (item.getItemId()) {
                    R.id.menu_clientes_detalhes -> {
                        findNavController(view).navigate(R.id.action_nav_titulos_to_nav_titulo_detalhes)
                    }
                    R.id.menu_clientes_excluir -> {
                       // mostraConfirmacaoExclusao(position)
                    }
                }
                return false
            }
        })
        popup.show()
    }


}