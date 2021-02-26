package com.gabrielnogueirabezerra.trabalhofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.gabrielnogueirabezerra.trabalhofinal.dao.UsuarioDAO

class CadastroUsuarioActivity : AppCompatActivity() {

    var edtNomeUsu: EditText? = null
    var edtUsuario: EditText? = null
    var edtSenha: EditText? = null
    var edtConfirmaSenha: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        edtNomeUsu = findViewById(R.id.edtNomeUsu)
        edtUsuario = findViewById(R.id.EdtNomeL)
        edtSenha = findViewById(R.id.EdtSenha)
        edtConfirmaSenha = findViewById(R.id.edtConfirmaSenha)
    }

    fun cadastrar(view: View){
        if(edtNomeUsu?.text.toString().trim() == ""){
            Toast.makeText(this@CadastroUsuarioActivity, "Informe o nome do usuário", Toast.LENGTH_SHORT).show()
            edtNomeUsu?.requestFocus();
            return;
        }

        if(edtUsuario?.text.toString().trim() == ""){
            Toast.makeText(this@CadastroUsuarioActivity, "Informe o usuário", Toast.LENGTH_SHORT).show()
            edtUsuario?.requestFocus();
            return;
        }

        if(edtSenha?.text.toString().trim() == ""){
            Toast.makeText(this@CadastroUsuarioActivity, "Informe a senha", Toast.LENGTH_SHORT).show()
            edtSenha?.requestFocus();
            return;
        }

        if(edtConfirmaSenha?.text.toString().trim() == ""){
            Toast.makeText(this@CadastroUsuarioActivity, "Informe a confirmação da sua senha", Toast.LENGTH_SHORT).show()
            edtConfirmaSenha?.requestFocus();
            return;
        }
        if(edtSenha?.text.toString().trim() != edtConfirmaSenha?.text.toString().trim()) {
            Toast.makeText(this@CadastroUsuarioActivity, "Suas senhas não conferem", Toast.LENGTH_SHORT).show()
            edtSenha?.requestFocus();
            return;
        }

        UsuarioDAO.instance.cadastraUsuario(edtNomeUsu?.text.toString().trim(), edtUsuario?.text.toString().trim(), edtSenha?.text.toString().trim())
    }

    fun sair(view: View){
        finish()
    }
}
