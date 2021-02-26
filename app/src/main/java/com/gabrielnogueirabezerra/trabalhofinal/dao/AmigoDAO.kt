package com.gabrielnogueirabezerra.trabalhofinal.dao

import com.gabrielnogueirabezerra.trabalhofinal.classes.Amigo

class AmigoDAO private constructor() {

    private object HOLDER {
        val INSTANCE = AmigoDAO()
    }

    companion object {
        val instance: AmigoDAO by lazy { HOLDER.INSTANCE }
    }

    fun addAmigo(id: String){
        var amigo: Amigo = Amigo(Integer.parseInt(id), "Amigo teste")
        UsuarioDAO.instance.usuario?.amigos?.add(amigo);
    }
}