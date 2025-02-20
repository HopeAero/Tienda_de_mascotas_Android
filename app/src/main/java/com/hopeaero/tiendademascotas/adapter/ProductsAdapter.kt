package com.hopeaero.tiendademascotas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hopeaero.tiendademascotas.R

class ProductsAdapter(
    private val productList: List<ProductItem>,
    private val onItemClick: (ProductItem) -> Unit
) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProduct: ImageView = view.findViewById(R.id.imgProduct)
        val txtTitle: TextView = view.findViewById(R.id.txtTitle)
        val imgArrow: ImageView = view.findViewById(R.id.imgArrow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productItem = productList[position]
        holder.txtTitle.text = productItem.title
        holder.imgProduct.setImageResource(productItem.imageRes)

        holder.imgArrow.setOnClickListener {
            onItemClick(productItem)
        }
    }


    override fun getItemCount(): Int = productList.size
}