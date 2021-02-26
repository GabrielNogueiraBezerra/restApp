package com.gabrielnogueirabezerra.trabalhofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.gabrielnogueirabezerra.trabalhofinal.dao.UsuarioDAO

class MainActivity : AppCompatActivity() {

    var edtUsuario: EditText? = null;
    var edtSenha: EditText? = null;
    var buttonEntrar: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        window.statusBarColor = resources.getColor(R.color.colorAccent);

        edtUsuario = findViewById(R.id.EdtNomeL);
        edtSenha = findViewById(R.id.EdtSenha)
        buttonEntrar = findViewById(R.id.btnLog)
    }

    fun clickCadastrar(view: View){
        val intent = Intent(this, CadastroUsuarioActivity::class.java)
        startActivity(intent)
    }

    fun clickEntrar(view: View){
        if(edtUsuario?.text.toString().trim() == ""){
            Toast.makeText(this@MainActivity, "Informe o usuário", Toast.LENGTH_SHORT).show()
            edtUsuario?.requestFocus();
            return;
        }

        if(edtSenha?.text.toString().trim() == ""){
            Toast.makeText(this@MainActivity, "Informe a senha", Toast.LENGTH_SHORT).show()
            edtSenha?.requestFocus();
            return;
        }

        UsuarioDAO.instance.buscaUsuario(edtUsuario?.text.toString().trim(), edtSenha?.text.toString().trim())

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
