package com.hopeaero.tiendademascotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import com.hopeaero.tiendademascotas.adapter.CareAnimalAdapter
import com.hopeaero.tiendademascotas.adapter.ProductItem
import com.hopeaero.tiendademascotas.adapter.ProductsAdapter
import com.hopeaero.tiendademascotas.model.Cuidado_Animal
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
        setupRecyclerViewForCare()

    }

    private fun setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Cuidados Básicos"))
        tabLayout.addTab(tabLayout.newTab().setText("Artículos"))

        // Seleccionar el primer tab por defecto
        tabLayout.getTabAt(0)?.select()

        // Listener para detectar cambios en los tabs
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> setupRecyclerViewForCare() // Mostrar datos para "Cuidados Básicos"
                    1 -> setupRecyclerViewForProducts() // Mostrar datos para "Artículos"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setupRecyclerViewForCare() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val cuidados = listOf(
            Cuidado_Animal("Perros", R.drawable.dog_pet, R.raw.single_dog),
            Cuidado_Animal("Gatos", R.drawable.cat_silhouette, R.raw.cat_meow),
            Cuidado_Animal("Conejos", R.drawable.rabbit_silhouette, R.raw.cambalache),
        )

        val adapter = CareAnimalAdapter(cuidados) { cuidado ->

        }
        recyclerView.adapter = adapter
    }

    private fun setupRecyclerViewForProducts() {
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