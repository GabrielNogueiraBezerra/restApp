package com.gabrielnogueirabezerra.trabalhofinal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.gabrielnogueirabezerra.trabalhofinal.classes.Amigo
import com.gabrielnogueirabezerra.trabalhofinal.dao.UsuarioDAO


class AmigosHomeFragment : Fragment() {

    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_amigos_home, container, false)
        listView = view.findViewById(R.id.listaAmigos)
        buscaAmigos()
        return view
    }

    private fun buscaAmigos(){
        var total: Int? = UsuarioDAO.instance.usuario?.amigos?.size;

        var listItems: Array<String?> = arrayOfNulls(total!!)

        for (i in 0 until total){
            var item: Amigo = UsuarioDAO.instance.usuario?.amigos!![i]
            listItems[i] = item.nome;
        }

        listView?.adapter = ArrayAdapter(activity!!, android.R.layout.simple_list_item_1, listItems)
    }

}
