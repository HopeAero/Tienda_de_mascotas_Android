package com.hopeaero.tiendademascotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import com.hopeaero.tiendademascotas.adapter.ProductItem
import com.hopeaero.tiendademascotas.adapter.ProductsAdapter
import com.hopeaero.tiendademascotas.model.Producto

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
        val jsonString = resources.openRawResource(R.raw.api_productos).bufferedReader().use { it.readText() }
        val gson = Gson()
        val productos: List<Producto> = gson.fromJson(jsonString, Array<Producto>::class.java).toList()

        recyclerView.layoutManager = LinearLayoutManager(this)
        val products = productos.map { producto ->
            ProductItem(
                producto.nombre,
                producto.descripcion,
                producto.precio.toString(),
                producto.imagen
            )
        }

        val adapter = ProductsAdapter(products)
        recyclerView.adapter = adapter

    }
}