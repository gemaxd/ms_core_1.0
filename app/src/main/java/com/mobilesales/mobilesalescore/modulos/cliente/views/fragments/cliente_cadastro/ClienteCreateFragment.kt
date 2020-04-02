package com.mobilesales.mobilesalescore.modulos.cliente.views.fragments.cliente_cadastro

import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.mobilesales.mobilesalescore.AppDatabase
import com.mobilesales.mobilesalescore.R
import com.mobilesales.mobilesalescore.models.cliente.Cliente
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_clientes_create.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ClientesCreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClientesCreateFragment : Fragment() {

    private var cliNom : String = ""
    private var cliFan : String = ""
    private var tipCli : String = ""
    private var cliCpf : String = ""
    private var cliEnd : String = ""
    private var cliBai : String = ""
    private var cliNum : String = ""
    private var cliCep : String = ""
    private var cliEst : String = ""
    private var cliCid : String = ""
    private var cliSuf : String = ""
    private var cliIns : String = ""
    private var cliTel : String = ""
    private var cliEma : String = ""

    private lateinit var clientesCreateViewModel: ClienteCreateViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        clientesCreateViewModel = ViewModelProviders.of(this,
            ClienteCreateViewModelFactory(
                context!!
            )
        ).get(ClienteCreateViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_clientes_create, container, false)
        val title: TextView = activity!!.main_toolbar_label
        val subTitle: TextView = activity!!.main_toolbar_sublabel

        clientesCreateViewModel.textTitle.observe(this, Observer {
            title.text = it
        })

        clientesCreateViewModel.textSubtitle.observe(this, Observer {
            subTitle.text = it
        })
        setHasOptionsMenu(true)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    fun initListeners(){
        cadastro_cliente_btn_cadastrar.setOnClickListener {
            cliNom = cliente_create_nome.editText?.text.toString()
            cliFan = cliente_create_fantasia.editText?.text.toString()
            tipCli = cliente_create_tipo.editText?.text.toString()
            cliCpf = cliente_create_cpf_cnpj.editText?.text.toString()
            cliEnd = cliente_create_endereco.editText?.text.toString()
            cliBai = cliente_create_bairro.editText?.text.toString()
            cliNum = cliente_create_numero.editText?.text.toString()
            cliCep = cliente_create_cep.editText?.text.toString()
            cliEst = cliente_create_estado.editText?.text.toString()
            cliCid = cliente_create_cidade.editText?.text.toString()
            cliSuf = cliente_create_suframa.editText?.text.toString()
            cliIns = cliente_create_inscricao.editText?.text.toString()
            cliTel = cliente_create_telefone.editText?.text.toString()
            cliEma = cliente_create_email.editText?.text.toString()

            var cliente = Cliente()
            cliente.nomCli      = cliNom
            cliente.nomFan      = cliFan
            cliente.tipCli      = tipCli
            cliente.cliCpfCnpj  = cliCpf
            cliente.cliEnd      = cliEnd

            if(cliNom.length > 5){

                cliente_create_nome.isErrorEnabled      = false
                cliente_create_fantasia.isErrorEnabled  = false
                cliente_create_tipo.isErrorEnabled      = false
                cliente_create_cpf_cnpj.isErrorEnabled  = false

                /*inserirCliente(cliente)
                this.findNavController().popBackStack()*/
            }else{
                cliente_create_nome.isErrorEnabled = true
                cliente_create_nome.error = "Nome de cliente inválido."

                cliente_create_fantasia.isErrorEnabled = true
                cliente_create_fantasia.error = "Nome de cliente inválido."

                cliente_create_tipo.isErrorEnabled = true
                cliente_create_tipo.error = "Nome de cliente inválido."

                cliente_create_cpf_cnpj.isErrorEnabled = true
                cliente_create_cpf_cnpj.error = "Nome de cliente inválido."
            }

        }
    }

    fun inserirCliente(cliente : Cliente){
        var db = AppDatabase.getAppDatabase(context!!)



        Thread{
            cliente.cliCpfCnpj = "444.999.159-33"
            cliente.dataAtualizacao = DateUtils.DAY_IN_MILLIS
            cliente.rowDel = 0

            db.clienteDao().insertAll(cliente)
        }.start()
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ClientesCreateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
