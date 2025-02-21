package com.hopeaero.tiendademascotas.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hopeaero.tiendademascotas.Pet
import com.hopeaero.tiendademascotas.R

class AdoptAdapter(private var petList: List<Pet>, private var onItemClick: (Pet) -> Unit) : RecyclerView.Adapter<AdoptAdapter.PetViewHolder>() {

    class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pet_name: TextView = itemView.findViewById(R.id.pet_name)
        val pet_image: ImageView = itemView.findViewById(R.id.pet_image)
        val pet_details: TextView = itemView.findViewById(R.id.pet_details)
        val detail_button: ImageView = itemView.findViewById(R.id.imgArrow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pet, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val pet = petList[position]
        Log.e("PET IMAGE", "Binding pet: ${pet.imageResources[0]}")
        Glide.with(holder.itemView.context)
            .load(pet.imageResources[0])
            .placeholder(R.drawable.logo) // Imagen de placeholder mientras se carga
            .error(R.drawable.logo) // Imagen de error si falla la carga
            .into(holder.pet_image)
        holder.pet_name.text = pet.name
        holder.pet_details.text = "${pet.race} | ${pet.age}"

        holder.detail_button.setOnClickListener{
            onItemClick(pet)
        }
    }

    override fun getItemCount() = petList.size

    fun updateData(newPets: List<Pet>, newOnItemClick: (Pet) -> Unit) {
        petList = newPets
        onItemClick = newOnItemClick
        notifyDataSetChanged()
    }
}