package com.gabrielnogueirabezerra.trabalhofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.gabrielnogueirabezerra.trabalhofinal.classes.Prato
import com.gabrielnogueirabezerra.trabalhofinal.dao.EmpresaDAO

class PratosFragment : Fragment() {

    var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_pratos, container, false)

        listView = view.findViewById(R.id.listaPratos)

        var total: Int? = EmpresaDAO.instance.empresaSelecionada?.pratos?.size;

        var listItems: Array<String?> = arrayOfNulls<String>(total!!)

        for (i in 0 until total){
            var item: Prato = EmpresaDAO.instance.empresaSelecionada?.pratos!![i]
            listItems[i] = item.nome
        }

        listView?.adapter = ArrayAdapter(activity!!, android.R.layout.simple_list_item_1, listItems)

        return view
    }
}
