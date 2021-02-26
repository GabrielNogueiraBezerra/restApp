package com.gabrielnogueirabezerra.trabalhofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.gabrielnogueirabezerra.trabalhofinal.dao.UsuarioDAO

class ConfiguracoesFragment : Fragment() {

    var tvUsuario: TextView? = null
    var btnSair: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_configuracoes, container, false)

        tvUsuario = view.findViewById(R.id.tvUsuario)

        tvUsuario?.text = "Usuario: #" + UsuarioDAO.instance.usuario?.id.toString()
        btnSair = view.findViewById(R.id.btnSair)
        btnSair?.setOnClickListener { sair() }

        return view
    }

    fun sair(){
        activity?.finish()
    }

}
