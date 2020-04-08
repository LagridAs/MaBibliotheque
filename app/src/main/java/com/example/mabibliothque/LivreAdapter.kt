package com.example.mabibliothque

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/********Adapter***********/
class LivreAdapter(private val dataList:MutableList<Livre>): RecyclerView.Adapter<LivreAdapter.LivreHolder>() {
    var onItemClick: ((Livre) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivreHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LivreHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: LivreHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }


    /********HolderVew********/

    inner class LivreHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_livre_view, parent, false)
    ){
        private var picLivre: ImageView?=null
        private var titrLivre: TextView?=null
        private var autrLivre: TextView?=null
        private var voirLivreBtn: Button?=null

        init {
            picLivre=itemView.findViewById(R.id.livrepic)
            titrLivre=itemView.findViewById(R.id.titreLiv)
            autrLivre=itemView.findViewById(R.id.auteur)
            voirLivreBtn=itemView.findViewById(R.id.voirBtn)
        }

        fun bind(livre: Livre){
            livre.imageLivre?.let { picLivre?.setImageResource(it) }
            titrLivre?.text=livre.titre
            autrLivre?.text="de".plus(" ").plus(livre.auteur?.Nom)
            voirLivreBtn?.setOnClickListener{
                onItemClick?.invoke(livre)
            }
        }
    }
}