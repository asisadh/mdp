package com.example.dinnerdecider.product

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import com.example.dinnerdecider.R
import com.example.dinnerdecider.product.entity.Product

class ProductDetailActivity: ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product: Product? = intent.getSerializableExtra("product") as Product

        val productImage: ImageView = findViewById(R.id.productImage)
        val logo: ImageView = findViewById(R.id.logo)
        val price: TextView = findViewById(R.id.price)
        val brand: TextView = findViewById(R.id.brand)
        val name: TextView = findViewById(R.id.title)
        val homeBtn: Button = findViewById(R.id.home)

        productImage.setImageDrawable(applicationContext.getResource(product?.image ?: ""))
        logo.setImageDrawable(applicationContext.getResource(product?.logo ?: ""))
        price.text = product?.price
        name.text = product?.name
        brand.text = product?.brand

        homeBtn.setOnClickListener {
            finish()
        }

    }
}