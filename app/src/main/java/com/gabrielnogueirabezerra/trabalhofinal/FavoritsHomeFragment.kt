package com.gabrielnogueirabezerra.trabalhofinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.gabrielnogueirabezerra.trabalhofinal.classes.Empresa
import com.gabrielnogueirabezerra.trabalhofinal.dao.EmpresaDAO

class FavoritsHomeFragment : Fragment() {

    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_favorits_home, container, false)
        listView = view.findViewById(R.id.listaFavoritos)

        EmpresaDAO.instance.addEmpresas()

        var totalEmpresas: Int? = EmpresaDAO.instance.empresas?.size;

        var listItems: Array<String?> = arrayOfNulls<String>(totalEmpresas!!)

        for (i in 0 until totalEmpresas){
            var item: Empresa = EmpresaDAO.instance.empresas!![i]
            listItems[i] = item.nome;
        }

        listView?.adapter = ArrayAdapter(activity!!, android.R.layout.simple_list_item_1, listItems)
        listView?.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(activity, EmpresaAreaActivity::class.java)
            intent.putExtra("EmpresaPosition", position)
            startActivity(intent)
        }

        return view
    }
}
