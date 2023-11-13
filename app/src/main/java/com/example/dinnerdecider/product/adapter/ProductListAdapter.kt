package com.example.dinnerdecider.product.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dinnerdecider.R
import com.example.dinnerdecider.product.entity.Product
import com.example.dinnerdecider.product.getResource

class ProductListAdapter( private val products: List<Product>, private val onClick: (Product) -> Unit, private val onAddButtonClicked: (Product) -> Unit):
    RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    class ProductListViewHolder(context: Context, itemView: View, private val onClick:(Product) -> Unit, private val onAddButtonClicked: (Product) -> Unit): RecyclerView.ViewHolder(itemView){

        private val logoImageView: ImageView = itemView.findViewById(R.id.logo)
        private val itemImageView: ImageView = itemView.findViewById(R.id.productImage)
        private val titleText: TextView = itemView.findViewById(R.id.title)
        private val priceText: TextView = itemView.findViewById(R.id.price)
        private val brandText: TextView = itemView.findViewById(R.id.brand)
        private val addButton: Button = itemView.findViewById(R.id.add)
        private var currentProduct: Product? = null
        private val context: Context = context

        init {
            itemView.setOnClickListener{
                currentProduct?.let(onClick)
            }
            addButton.setOnClickListener {
                currentProduct?.let(onAddButtonClicked)
            }
        }

        fun bind(product: Product){
            currentProduct = product
            titleText.text = product.name
            priceText.text = product.price
            brandText.text = product.brand
            logoImageView.setImageDrawable(context.getResource(product.logo))
            itemImageView.setImageDrawable(context.getResource(product.image))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductListViewHolder(parent.context, view, onClick, onAddButtonClicked)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

}