package com.gabrielnogueirabezerra.trabalhofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.gabrielnogueirabezerra.trabalhofinal.dao.AmigoDAO
import java.lang.Exception

class AdicionaAmigoActivity : AppCompatActivity() {

    var edtIdAmigo: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adiciona_amigo)

        edtIdAmigo = findViewById(R.id.edtIdAmigo)
    }

    fun adicionaAmigo(view: View){
        try {
            if(edtIdAmigo?.text.toString().trim() == ""){
                Toast.makeText(this@AdicionaAmigoActivity, "Informe o id do amigo", Toast.LENGTH_SHORT).show()
                edtIdAmigo?.requestFocus();
                return;
            }

            AmigoDAO.instance.addAmigo(edtIdAmigo?.text.toString());
        }catch (e: Exception){
            Toast.makeText(this@AdicionaAmigoActivity, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun sair(view: View){
        finish()
    }
}
