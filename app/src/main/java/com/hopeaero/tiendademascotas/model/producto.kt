package com.hopeaero.tiendademascotas.model

data class Producto (
    val id: Int,
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val imagen: String
)