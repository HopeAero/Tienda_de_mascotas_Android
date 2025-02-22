package com.hopeaero.tiendademascotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.hopeaero.tiendademascotas.adapter.GalleryAdapter
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class PetGalleryActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_gallery)

        val petId = intent.getIntExtra("petId", -1)
        val petAnimal = intent.getStringExtra("petAnimal")
        var pet: Pet? = null
        when (petAnimal) {
            "Perro" -> pet = dogs.find { it.id == petId }
            "Gato" -> pet = cats.find { it.id == petId }
            "Conejo" -> pet = rabbits.find { it.id == petId }
            else -> return
        }
        val image = findViewById<ImageView>(R.id.imageViewDog)
        val name = findViewById<TextView>(R.id.textViewName)
        val race = findViewById<TextView>(R.id.textViewBreed)
        val age = findViewById<TextView>(R.id.textViewAge)
        val description = findViewById<TextView>(R.id.textViewDescription)
        val backButton = findViewById<MaterialButton>(R.id.backButton)

        Glide.with(this).load(pet?.imageResources?.get(0)).into(image)
        name.text = ("Nombre: " + pet?.name)
        race.text = ("Raza: " + pet?.race)
        age.text = ("Edad: " + pet?.age)
        description.text = ("[Descripción] " + pet?.description)
        backButton.text = "<  " + petAnimal + "s"

        viewPager2 = findViewById(R.id.viewPager)
        if (pet != null) {
            viewPager2.adapter = GalleryAdapter(this.supportFragmentManager, lifecycle, pet)
        }
    }
}