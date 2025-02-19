package com.hopeaero.tiendademascotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val petList = listOf(
            PetItem("Adopta un amigo", "Explora nuestra selección de adorables mascotas en busca de un nuevo hogar. ¡Adopta y cambia una vida!", R.drawable.adopt),
            PetItem("Todo para tu mascota", "Encuentra los mejores productos y consejos para mantener a tu mascota sana, feliz y consentida.", R.drawable.products)
        )

        recyclerView.adapter = PetAdapter(petList)
    }
}
