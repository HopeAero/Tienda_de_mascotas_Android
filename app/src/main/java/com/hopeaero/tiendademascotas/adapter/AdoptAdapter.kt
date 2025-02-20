package com.hopeaero.tiendademascotas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hopeaero.tiendademascotas.Pet
import com.hopeaero.tiendademascotas.R

class AdoptAdapter(private val petList: List<Pet>) : RecyclerView.Adapter<AdoptAdapter.PetViewHolder>() {

    class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pet_name: TextView = itemView.findViewById(R.id.pet_name)
        val pet_image: ImageView = itemView.findViewById(R.id.pet_image)
        val pet_details: TextView = itemView.findViewById(R.id.pet_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pet, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val pet = petList[position]
        holder.pet_image.setImageResource(pet.imageResource)
        holder.pet_name.text = pet.name
        holder.pet_details.text = pet.details
    }

    override fun getItemCount() = petList.size
}