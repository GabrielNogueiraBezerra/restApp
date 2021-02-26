package com.gabrielnogueirabezerra.trabalhofinal.dao

import com.gabrielnogueirabezerra.trabalhofinal.classes.Amigo
import com.gabrielnogueirabezerra.trabalhofinal.classes.Usuario

class UsuarioDAO {

    private object HOLDER {
        val INSTANCE = UsuarioDAO()
    }

    companion object {
        val instance: UsuarioDAO by lazy { HOLDER.INSTANCE }
    }

    var usuario: Usuario?  =null

    fun buscaUsuario(loginUsuario: String, senha: String){

        var amigos = ArrayList<Amigo>();

        var amigo1 = Amigo(2, "Amigo 1");

        amigos.add(amigo1);

        usuario = Usuario(1, "Gabriel", "gabrielnogueira", "123", amigos)
    }

    fun cadastraUsuario(nomeUsuario: String, usuario: String, senha: String){

    }
}