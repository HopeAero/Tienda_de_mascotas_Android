package com.hopeaero.tiendademascotas.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hopeaero.tiendademascotas.R

class ProductsAdapter(
    private val productList: List<ProductItem>,
) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProduct: ImageView = view.findViewById(R.id.imgProduct)
        val txtTitle: TextView = view.findViewById(R.id.txtTitle)
        val txtDescription: TextView = view.findViewById(R.id.txtDescription)
        val txtPrice: TextView = view.findViewById(R.id.txtPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productItem = productList[position]
        holder.txtTitle.text = productItem.title
        holder.txtDescription.text = productItem.description
        holder.txtPrice.text = productItem.price

        Glide.with(holder.itemView.context)
            .load(productItem.imageUrl)
            .placeholder(R.drawable.dog)
            .error(R.drawable.dog)
            .into(holder.imgProduct)
    }


    override fun getItemCount(): Int = productList.size
}