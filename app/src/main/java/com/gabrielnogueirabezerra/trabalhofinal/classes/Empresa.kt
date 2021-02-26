package com.gabrielnogueirabezerra.trabalhofinal.classes

class Empresa(val nome: String, val slogan: String, val observacao: String, val pratos: ArrayList<Prato>,
              val favorito: Boolean, val longitude: Float, val latitude: Float, val comentarios: ArrayList<Comentario>){
}