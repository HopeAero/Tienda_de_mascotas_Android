package com.hopeaero.tiendademascotas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hopeaero.tiendademascotas.R

class PetAdapter(
    private val petList: List<PetItem>,
    private val onItemClick: (PetItem) -> Unit
) :
    RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    class PetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPet: ImageView = view.findViewById(R.id.imgPet)
        val txtTitle: TextView = view.findViewById(R.id.txtTitle)
        val txtDescription: TextView = view.findViewById(R.id.txtDescription)
        val imgArrow: ImageView = view.findViewById(R.id.imgArrow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet_card, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val petItem = petList[position]
        holder.txtTitle.text = petItem.title
        holder.txtDescription.text = petItem.description
        holder.imgPet.setImageResource(petItem.imageRes)

        holder.imgArrow.setOnClickListener {
            onItemClick(petItem)
        }
    }


    override fun getItemCount(): Int = petList.size
}
