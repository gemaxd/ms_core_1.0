package com.mobilesales.mobilesalescore.ui.produtos

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
import com.mobilesales.mobilesalescore.models.pedido_item.Produto
import com.mobilesales.mobilesalescore.ui.clientes.interfaces.ProdutosItemClickListener
import com.mobilesales.mobilesalescore.ui.gallery.ProdutosViewModel
import kotlinx.android.synthetic.main.app_bar_main.*

class ProdutosFragment : Fragment(), ProdutosItemClickListener {

    private lateinit var produtosViewModel: ProdutosViewModel
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        produtosViewModel = ViewModelProviders.of(this, ProdutosViewModelFactory(context!!, this)).get(ProdutosViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_produtos, container, false)
        val title: TextView     = activity!!.main_toolbar_label
        val subTitle: TextView  = activity!!.main_toolbar_sublabel

        val recycler: RecyclerView = root.findViewById(R.id.produtos_recycler_produtos)

        produtosViewModel.recycler.observe(this, Observer {
            recycler.adapter = it
            recycler.layoutManager = LinearLayoutManager(context)
        })

        produtosViewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        produtosViewModel.textSubtitle.observe(this, Observer {
            subTitle.text = it
        })

        return root
    }

    override fun onProdutoClickOptions(view: View, position: Int) {
        produtosViewModel.mostrarPopUp(view, position)
    }

    override fun onProdutoClickQuickAdd(view: View, pro: Produto) {
        produtosViewModel.mostrarConfirmacaoInsercao(pro)
    }
}