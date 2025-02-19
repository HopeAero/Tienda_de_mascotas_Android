package com.hopeaero.tiendademascotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.hopeaero.tiendademascotas.adapter.AdoptAdapter


class DetailActivityPets : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pets)

        recyclerView = findViewById(R.id.recycler_view)
        tabLayout = findViewById(R.id.tabLayout)

        setupTabLayout()
        setupRecyclerView()
    }

    private fun setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Perros"))
        tabLayout.addTab(tabLayout.newTab().setText("Gatos"))
        tabLayout.addTab(tabLayout.newTab().setText("Conejos"))
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val pets = listOf(
            Pet("Nombre perro", "Raza | Edad", R.drawable.dog),
            Pet("Nombre perro", "Raza | Edad", R.drawable.dog_2),
            Pet("Nombre perro", "Raza | Edad", R.drawable.dog_3)
        )

        val adapter = AdoptAdapter(pets)
        recyclerView.adapter = adapter
    }
}