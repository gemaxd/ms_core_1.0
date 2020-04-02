package com.mobilesales.mobilesalescore.ui.titulos.detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.TitulosItemClickListener
import com.mobilesales.mobilesalescore.ui.gallery.TituloDetalhesViewModel
import com.mobilesales.mobilesalescore.ui.gallery.TitulosViewModel
import kotlinx.android.synthetic.main.app_bar_main.*

class TituloDetalhesFragment : Fragment(), TitulosItemClickListener {
    override fun onTituloClickOptions(view: View, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var titulosViewModel: TituloDetalhesViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        titulosViewModel = ViewModelProviders.of(this, TituloDetalhesViewModelFactory(context!!, this)).get(TituloDetalhesViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_titulo_detalhes, container, false)

        val title: TextView     = activity!!.main_toolbar_label
        val subTitle: TextView  = activity!!.main_toolbar_sublabel

        titulosViewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        titulosViewModel.textSubtitle.observe(this, Observer {
            subTitle.text = it
        })
        return root
    }
}