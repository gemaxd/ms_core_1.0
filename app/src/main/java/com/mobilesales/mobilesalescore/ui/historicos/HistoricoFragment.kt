package com.mobilesales.mobilesalescore.ui.historicos

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
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.HistoricotemClickListener
import com.mobilesales.mobilesalescore.ui.gallery.HistoricoViewModel
import kotlinx.android.synthetic.main.app_bar_main.*

class HistoricoFragment : Fragment(), HistoricotemClickListener {
    override fun onHistoricoClickOptions(view: View, position: Int) {

    }

    private lateinit var historicoViewModel: HistoricoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        historicoViewModel = ViewModelProviders.of(this, HistoricoViewModelFactory(activity!!.baseContext, this)).get(HistoricoViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_historicos, container, false)

        val title: TextView     = activity!!.main_toolbar_label
        val subTitle: TextView  = activity!!.main_toolbar_sublabel

        val recycler: RecyclerView = root.findViewById(R.id.historicos_recycler_historicos)

        historicoViewModel.recycler.observe(this, Observer {
            recycler.adapter = it
            recycler.layoutManager = LinearLayoutManager(context)
        })

        historicoViewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        historicoViewModel.textSubtitle.observe(this, Observer {
            subTitle.text = it
        })
        return root
    }
}