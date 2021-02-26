package com.gabrielnogueirabezerra.trabalhofinal.dao

import com.gabrielnogueirabezerra.trabalhofinal.classes.Comentario
import com.gabrielnogueirabezerra.trabalhofinal.classes.Empresa
import com.gabrielnogueirabezerra.trabalhofinal.classes.Prato
import com.gabrielnogueirabezerra.trabalhofinal.classes.Usuario

class EmpresaDAO private constructor() {

    private object HOLDER {
        val INSTANCE = EmpresaDAO()
    }

    companion object {
        val instance: EmpresaDAO by lazy { HOLDER.INSTANCE }
    }

    var empresaSelecionada: Empresa? = null

    var empresas: ArrayList<Empresa>? = null

    fun addComentario(comentario: String){
        var idUsuario: Int? = UsuarioDAO.instance.usuario?.id
        var nomeUsuario: String? = UsuarioDAO.instance.usuario?.nome

        var comentario: Comentario = Comentario(1, comentario, idUsuario!!, nomeUsuario!!)
        empresaSelecionada?.comentarios?.add(comentario);


    }

    fun addEmpresas(){

        empresas = ArrayList<Empresa>()

        var pratos1: ArrayList<Prato> = ArrayList<Prato>()

        var prato1: Prato = Prato("Macarronada", "macarronada com carne desfiada e molho", "5")

        pratos1.add(prato1);

        var e1: Empresa = Empresa("Empresa 1", "Slogan empresa 1", "Alguma observação da empresa", pratos1, true,
            0F, 0F, ArrayList<Comentario>())
        var e2: Empresa = Empresa("Empresa 2", "Slogan empresa 2", "Alguma observação da empresa", ArrayList<Prato>(), false,
            0F, 0F,ArrayList<Comentario>())
        var e3: Empresa = Empresa("Empresa 3", "Slogan empresa 3", "Alguma observação da empresa", ArrayList<Prato>(), true,
            0F, 0F,ArrayList<Comentario>())
        var e4: Empresa = Empresa("Empresa 4", "Slogan empresa 4", "Alguma observação da empresa", ArrayList<Prato>(), true,
            0F, 0F,ArrayList<Comentario>())
        var e5: Empresa = Empresa("Empresa 5", "Slogan empresa 5", "Alguma observação da empresa", ArrayList<Prato>(), true,
            0F, 0F,ArrayList<Comentario>())

        empresas?.add(e1)
        empresas?.add(e2)
        empresas?.add(e3)
        empresas?.add(e4)
        empresas?.add(e5)
    }
}