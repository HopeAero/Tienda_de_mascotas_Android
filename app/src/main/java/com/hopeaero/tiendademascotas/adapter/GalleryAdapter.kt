package com.hopeaero.tiendademascotas.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hopeaero.tiendademascotas.MediaFragment
import com.hopeaero.tiendademascotas.Pet

class GalleryAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val pet: Pet
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = pet.imageResources.size + if (pet.video != null) 1 else 0

    override fun createFragment(position: Int): Fragment {
        return if (pet.video != null && position == pet.imageResources.size) {
            MediaFragment.newInstance(null, pet.video)
        } else {
            MediaFragment.newInstance(pet.imageResources[position], null)
        }
    }
}