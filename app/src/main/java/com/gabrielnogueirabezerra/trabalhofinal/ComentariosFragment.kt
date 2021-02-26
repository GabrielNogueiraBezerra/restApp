package com.gabrielnogueirabezerra.trabalhofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.gabrielnogueirabezerra.trabalhofinal.classes.Comentario
import com.gabrielnogueirabezerra.trabalhofinal.dao.EmpresaDAO

class ComentariosFragment : Fragment() {

    var edtComentario: EditText? = null
    var listComentarios: ListView? = null
    var buttonAdd: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun buscaComentarios(){
        var total: Int? = EmpresaDAO.instance.empresaSelecionada?.comentarios?.size;

        var listItems: Array<String?> = arrayOfNulls<String>(total!!)

        for (i in 0 until total){
            var item: Comentario = EmpresaDAO.instance.empresaSelecionada?.comentarios!![i]
            listItems[i] = item.comentario;
        }

        listComentarios?.adapter = ArrayAdapter(activity!!, android.R.layout.simple_list_item_1, listItems)
    }

    fun addComentario(){
        if(edtComentario?.text.toString().trim() == ""){
            Toast.makeText(activity, "Informe o comentario", Toast.LENGTH_SHORT).show()
            edtComentario?.requestFocus();
            return;
        }

        EmpresaDAO.instance.addComentario(edtComentario?.text.toString().trim());
        buscaComentarios()
        edtComentario?.setText("")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_comentarios, container, false)

        edtComentario = view.findViewById(R.id.edtComentario)
        listComentarios = view.findViewById(R.id.listComentarios)
        buttonAdd = view.findViewById(R.id.btnCadastrarComentario)
        buttonAdd?.setOnClickListener { addComentario() }

        buscaComentarios()

        return view
    }
}
