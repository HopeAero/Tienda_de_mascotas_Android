package com.hopeaero.tiendademascotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.hopeaero.tiendademascotas.adapter.ProductItem
import com.hopeaero.tiendademascotas.adapter.ProductsAdapter

class DetailActivityProducts : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_products)

        recyclerView = findViewById(R.id.recycler_view)
        tabLayout = findViewById(R.id.tabLayout)

        setupTabLayout()
        setupRecyclerView()
    }

    private fun setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Cuidados Básicos"))
        tabLayout.addTab(tabLayout.newTab().setText("Artículos"))
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val products = listOf(
            ProductItem("Perros", R.drawable.dog),
            ProductItem("Gatos", R.drawable.dog_2),
            ProductItem("Conejos", R.drawable.dog_3)
        )

        val adapter = ProductsAdapter(products) { product ->
            // Handle item click
        }
        recyclerView.adapter = adapter


    }
}