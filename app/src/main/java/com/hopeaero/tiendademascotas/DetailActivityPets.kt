package com.hopeaero.tiendademascotas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.hopeaero.tiendademascotas.adapter.AdoptAdapter
import com.hopeaero.tiendademascotas.dogs
import com.hopeaero.tiendademascotas.cats
import com.hopeaero.tiendademascotas.rabbits

class DetailActivityPets : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tabLayout: TabLayout
    private lateinit var adapter: AdoptAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pets)

        recyclerView = findViewById(R.id.recycler_view)
        tabLayout = findViewById(R.id.tabLayout)

        setupTabLayout()
        setupRecyclerView()

        recyclerView.setOnClickListener {
            val intent = Intent(this, PetGalleryActivity::class.java)
            startActivity(intent)

        }

    }

    private fun setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Perros"))
        tabLayout.addTab(tabLayout.newTab().setText("Gatos"))
        tabLayout.addTab(tabLayout.newTab().setText("Conejos"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> updateRecyclerView("Perros")
                    1 -> updateRecyclerView("Gatos")
                    2 -> updateRecyclerView("Conejos")
                    else -> Log.e("DetailActivityProducts", "Invalid tab position")
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Not needed for this example
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Not needed for this example
            }
        })
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AdoptAdapter(dogs, { pet ->
             intent = Intent(this, PetGalleryActivity::class.java)
            intent.putExtra("petId", pet.id)
            startActivity(intent)
        })
        recyclerView.adapter = adapter
    }

    private fun updateRecyclerView(tabName: String) {
        val newOnItemClick: (Pet) -> Unit = { pet ->
            /*val intent = Intent(this, DetailActivityProducts::class.java)
            intent.putExtra("petId", pet.id)
            startActivity(intent)*/
        }

        if (tabName == "Perros") {
            adapter.updateData(dogs, newOnItemClick)
        } else if (tabName == "Gatos") {
            adapter.updateData(cats, newOnItemClick)
        } else if (tabName == "Conejos") {
            adapter.updateData(rabbits, newOnItemClick)
        }
    }
}