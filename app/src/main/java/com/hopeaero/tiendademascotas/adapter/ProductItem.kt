package com.hopeaero.tiendademascotas.adapter

data class ProductItem (val title: String, val description: String, val price: String, val imageUrl: String) {
    override fun toString(): String {
        return title
    }
}