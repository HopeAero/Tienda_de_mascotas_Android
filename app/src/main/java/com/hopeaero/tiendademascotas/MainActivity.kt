package com.hopeaero.tiendademascotas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hopeaero.tiendademascotas.adapter.PetAdapter
import com.hopeaero.tiendademascotas.adapter.PetItem

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

        recyclerView.adapter = PetAdapter(petList) { petItem ->

            if (petItem.title == "Adopta un amigo") {
                val intent = Intent(this, DetailActivityPets::class.java)
                intent.putExtra("petTitle", petItem.title)
                startActivity(intent)
            } else if (petItem.title == "Todo para tu mascota") {
                val intent = Intent(this, DetailActivityProducts::class.java)
                intent.putExtra("petTitle", petItem.title)
                startActivity(intent)
            }


        }
    }
}
