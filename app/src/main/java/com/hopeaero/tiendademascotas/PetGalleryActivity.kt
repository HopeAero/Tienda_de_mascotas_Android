package com.hopeaero.tiendademascotas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.hopeaero.tiendademascotas.adapter.AdoptAdapter
import com.hopeaero.tiendademascotas.adapter.PetAdapter
import com.hopeaero.tiendademascotas.adapter.PetItem

class PetGalleryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdoptAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_gallery)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        setupRecyclerView()


    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AdoptAdapter(dogs, { pet ->
            /*val intent = Intent(this, DetailActivityProducts::class.java)
            intent.putExtra("petId", pet.id)
            startActivity(intent)*/
        })
        recyclerView.adapter = adapter
    }


}