package com.example.mabibliothque

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_details_livre.*

class DetailsLivreFragment : Fragment() {
    private var v:View?=null
    private var titreView:TextView?=null
    private var auteurView:TextView?=null
    private var auteurpicView:ImageView?=null
    private var livrepicView:ImageView?=null
    private var resumeView:TextView?=null
    lateinit var livre:Livre


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"dakhal oncreate")

        retainInstance = true

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        Log.d(TAG,"dakhal oncreate view ")
        v= inflater.inflate(R.layout.fragment_details_livre, container, false)
        Log.d(TAG,"kharaj oncreate view ")
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"dakhal on view created ")

        /*******initialisation******/
        titreView=v?.findViewById(R.id.titreLiv)
        auteurView=v?.findViewById(R.id.auteurname)
        auteurpicView=v?.findViewById(R.id.auteurpic)
        livrepicView=v?.findViewById(R.id.Livpic)
        resumeView=v?.findViewById(R.id.resumeLiv)

        /*******attribuler les données****/
        livre = arguments?.getSerializable("livre") as Livre
        titreView?.text=livre.titre
        auteurView?.text= livre.auteur?.Nom
        livre.auteur?.photo?.let { auteurpicView?.setImageResource(it) }
        livre.imageLivre?.let { livrepicView?.setImageResource(it) }
        resumeView?.text=livre.resume



        //titreLiv.text=livre.titre
        //auteurname.text=livre.auteur?.Nom
        //livre.auteur?.photo?.let { auteurpic?.setImageResource(it) }
        //livre.imageLivre?.let { Livpic?.setImageResource(it) }
        //resumeLiv.text = livre.resume
    }

    companion object {

        fun newInstance():DetailsLivreFragment
        {
            return DetailsLivreFragment()
        }
    }
}
