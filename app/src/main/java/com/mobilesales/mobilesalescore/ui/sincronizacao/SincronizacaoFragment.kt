package com.mobilesales.mobilesalescore.ui.sincronizacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.ui.gallery.SincronizacaoViewModel
import kotlinx.android.synthetic.main.app_bar_main.*

class SincronizacaoFragment : Fragment() {

    private lateinit var sincronizacaoViewModel: SincronizacaoViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        sincronizacaoViewModel = ViewModelProviders.of(this, SincronizacaoViewModelFactory(activity!!.baseContext)).get(SincronizacaoViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_sincronizacao, container, false)
        val title: TextView     = activity!!.main_toolbar_label
        val subTitle: TextView  = activity!!.main_toolbar_sublabel

        sincronizacaoViewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        sincronizacaoViewModel.textSubtitle.observe(this, Observer {
            subTitle.text = it
        })
        return root
    }
}