package com.gabrielnogueirabezerra.trabalhofinal.adapters

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.gabrielnogueirabezerra.trabalhofinal.ComentariosFragment
import com.gabrielnogueirabezerra.trabalhofinal.PratosFragment


class AdapterTabViewEmpresa(private val myContext: Context, fm: FragmentManager, private var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        return if(position == 0){
            PratosFragment()
        }else{
            ComentariosFragment()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}