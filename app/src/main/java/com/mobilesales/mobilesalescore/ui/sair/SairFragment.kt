package com.mobilesales.mobilesalescore.ui.sair

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.ui.gallery.SairViewModel
import kotlinx.android.synthetic.main.app_bar_main.*

class SairFragment : Fragment() {

    private lateinit var sairViewModel: SairViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        sairViewModel = ViewModelProviders.of(this, SairViewModelFactory(activity!!.baseContext)).get(SairViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_sair, container, false)
        val title: TextView     = activity!!.main_toolbar_label
        val subTitle: TextView  = activity!!.main_toolbar_sublabel

        sairViewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        sairViewModel.text.observe(this, Observer {
            subTitle.text = it
        })

        return root
    }
}