package com.gabrielnogueirabezerra.trabalhofinal

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.gabrielnogueirabezerra.trabalhofinal.dao.UsuarioDAO
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    var bottomNavigationView: BottomNavigationView? = null
    var containerFragment: FrameLayout? = null


    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(findViewById(R.id.toolbar))

        bottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigationView?.setOnNavigationItemSelectedListener(this);

        containerFragment = findViewById(R.id.container)

        var textUsuario: TextView? = drawerLayout?.findViewById<TextView>(R.id.nav_header_textView)

        textUsuario?.text = UsuarioDAO.instance.usuario?.nome + " #" + UsuarioDAO.instance.usuario?.id.toString()

        inicio()
    }

    fun addAmigo(view: View){
        val intent = Intent(this, AdicionaAmigoActivity::class.java)
        startActivity(intent)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                inicio()
            }
            R.id.navigation_favor -> {
                favoritos()
            }
            R.id.navigation_friends -> {
                amigos()
            }
            R.id.navigation_configuracoes -> {
                configuracoes()
            }
        }
        return true
    }

    private fun configuracoes(){
        supportActionBar?.title = "Configurações";
        var fragment: Fragment = ConfiguracoesFragment()
        openFragment(fragment)
    }

    private fun amigos(){
        supportActionBar?.title = "Amigos";
        var fragment: Fragment = AmigosHomeFragment()
        openFragment(fragment)
    }

    private fun favoritos(){
        supportActionBar?.title = "Favoritos";
        var fragment: Fragment = FavoritsHomeFragment()
        openFragment(fragment)
    }

    private fun inicio(){
        supportActionBar?.title = "Inicio";
        var fragment: Fragment = MapHomeFragment()
        openFragment(fragment)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
