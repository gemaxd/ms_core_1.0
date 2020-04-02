package com.mobilesales.mobilesalescore.ui.titulos

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
import com.mobilesales.mobilesalescore.ui.gallery.TitulosViewModel
import kotlinx.android.synthetic.main.app_bar_main.*

class TitulosFragment : Fragment(), TitulosItemClickListener {


    private lateinit var titulosViewModel: TitulosViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        titulosViewModel = ViewModelProviders.of(this, TitulosViewModelFactory(context!!, this)).get(TitulosViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_titulos, container, false)

        val title: TextView     = activity!!.main_toolbar_label
        val subTitle: TextView  = activity!!.main_toolbar_sublabel

        val recycler: RecyclerView = root.findViewById(R.id.titulos_recycler_titulos)

        titulosViewModel.recycler.observe(this, Observer {
            recycler.adapter = it
            recycler.layoutManager = LinearLayoutManager(context)
        })

        titulosViewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        titulosViewModel.textSubtitle.observe(this, Observer {
            subTitle.text = it
        })
        return root
    }

    override fun onTituloClickOptions(view: View, position: Int) {
        titulosViewModel.mostrarPopUp(view, position)
    }


}