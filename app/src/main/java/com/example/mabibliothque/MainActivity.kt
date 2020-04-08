package com.example.mabibliothque

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity(),Communicator {
    lateinit var adapterLvr:LivreAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var livreList: MutableList<Livre>
    lateinit var auteurList:MutableList<Auteur>
    //lateinit var comm:Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auteurList= mutableListOf(
            Auteur(getString(R.string.auteur1),R.drawable.aut1),
            Auteur(getString(R.string.auteur2),R.drawable.aut1),
            Auteur(getString(R.string.auteur3),R.drawable.aut1),
            Auteur(getString(R.string.auteur4),R.drawable.aut1),
            Auteur(getString(R.string.auteur6),R.drawable.aut1),
            Auteur(getString(R.string.auteur1),R.drawable.aut1)
        )
        livreList= mutableListOf(
            Livre(getString(R.string.titre1),R.drawable.liv1,auteurList[0],getString(R.string.resume1)),
            Livre(getString(R.string.titre1),R.drawable.liv2,auteurList[1],getString(R.string.resume2)),
            Livre(getString(R.string.titre1),R.drawable.liv3,auteurList[2],getString(R.string.resume3)),
            Livre(getString(R.string.titre1),R.drawable.liv4,auteurList[3],getString(R.string.resume4)),
            Livre(getString(R.string.titre1),R.drawable.liv5,auteurList[4],getString(R.string.resume5)),
            Livre(getString(R.string.titre1),R.drawable.liv6,auteurList[5],getString(R.string.resume6))
        )
        adapterLvr=LivreAdapter(livreList)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerLivre.apply {
            layoutManager= linearLayoutManager
            adapter=adapterLvr
        }
        adapterLvr.onItemClick = { livre ->
            livreCom(livre)
            Log.d("FRAGMANRT", livre.titre)
        }


    }

    override fun livreCom(livre: Livre) {
        Log.d("MAINACT",livre.titre)
        val bundle1 = Bundle()
        bundle1.putSerializable("livre",livre)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragment = DetailsLivreFragment()
        fragment.arguments = bundle1
        transaction.replace(R.id.mainAct, fragment)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()

    }
}
