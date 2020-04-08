package com.example.mabibliothque

import java.io.Serializable

data class Livre(val titre:String?,
                 val imageLivre:Int?,
                 val auteur:Auteur?,
                 val resume:String?):Serializable
