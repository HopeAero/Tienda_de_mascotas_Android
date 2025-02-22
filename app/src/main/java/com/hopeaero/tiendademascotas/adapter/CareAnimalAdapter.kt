package com.hopeaero.tiendademascotas.adapter

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hopeaero.tiendademascotas.R
import com.hopeaero.tiendademascotas.model.Cuidado_Animal

class CareAnimalAdapter(
    private val careAnimal: List<Cuidado_Animal>,
    private val onClick : (Cuidado_Animal) -> Unit
): RecyclerView.Adapter<CareAnimalAdapter.CareAnimalViewHolder>() {

    class CareAnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgCare: ImageView = view.findViewById(R.id.animalImage)
        val txtTitle: TextView = view.findViewById(R.id.animalName)
        val audioImg : ImageView = view.findViewById(R.id.imgPlayer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CareAnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basic_care, parent, false)
        return CareAnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: CareAnimalViewHolder, position: Int) {
        val careAnimalItem = careAnimal[position]
        holder.txtTitle.text = careAnimalItem.titulo
        holder.imgCare.setImageResource(careAnimalItem.imagenId)

        holder.audioImg.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(holder.itemView.context, careAnimalItem.audioResourceId)
            mediaPlayer.start()

            // Liberar recursos después de reproducir el sonido
            mediaPlayer.setOnCompletionListener { mp ->
                mp.release()
            }
        }


    }

    override fun getItemCount(): Int = careAnimal.size

}