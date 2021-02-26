package com.gabrielnogueirabezerra.trabalhofinal

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.gabrielnogueirabezerra.trabalhofinal.adapters.AdapterTabViewEmpresa
import com.gabrielnogueirabezerra.trabalhofinal.classes.Empresa
import com.gabrielnogueirabezerra.trabalhofinal.dao.EmpresaDAO
import com.google.android.material.tabs.TabLayout

class EmpresaAreaActivity : AppCompatActivity() {

    var empresa: Empresa? = null
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    var tvNomeEmpresa: TextView? = null
    var tvSlogan: TextView? = null
    var imgFavorite: ImageView? = null

    fun onTapFavorite(view: View){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empresa_area)

        val extras = intent.extras
        if (extras != null) {
            val empresaPosition = extras.getInt("EmpresaPosition")
            empresa = EmpresaDAO.instance.empresas?.get(empresaPosition)
        }

        EmpresaDAO.instance.empresaSelecionada = empresa

        tvNomeEmpresa = findViewById(R.id.tvNomeEmpresa)
        tvSlogan = findViewById(R.id.tvSlogan)

        tvNomeEmpresa?.text = empresa?.nome
        tvSlogan?.text = empresa?.slogan

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Pratos"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Comentarios"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = AdapterTabViewEmpresa(this, supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }
}
