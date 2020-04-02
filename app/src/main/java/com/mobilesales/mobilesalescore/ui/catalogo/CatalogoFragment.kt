package com.mobilesales.mobilesalescore.ui.catalogo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.ui.gallery.CatalogoViewModel
import com.mobilesales.mobilesalescore.ui.gallery.ProdutosViewModel
import kotlinx.android.synthetic.main.app_bar_main.*

class CatalogoFragment : Fragment() {

    private lateinit var catalogoViewModel: CatalogoViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        catalogoViewModel = ViewModelProviders.of(this, CatalogoViewModelFactory(activity!!.baseContext)).get(CatalogoViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_catalogo, container, false)

        val title: TextView     = activity!!.main_toolbar_label
        val subTitle: TextView  = activity!!.main_toolbar_sublabel
        catalogoViewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        catalogoViewModel.textSubtitle.observe(this, Observer {
            subTitle.text = it
        })
        return root
    }
}