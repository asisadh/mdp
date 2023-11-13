package com.example.dinnerdecider.product

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dinnerdecider.R
import com.example.dinnerdecider.product.adapter.ProductListAdapter
import com.example.dinnerdecider.product.entity.Product


class ProductListActivity: ComponentActivity() {

    var cardItems = arrayListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val productAdapter = ProductListAdapter(createProductList(), onClick = { onClickProduct(it) }, onAddButtonClicked = { onAddButtonClicked(it) })
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = productAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        val viewCartBtn: Button = findViewById(R.id.cart)
        viewCartBtn.setOnClickListener { onViewCartClicked() }
    }

    private fun onViewCartClicked() {
        val namesOfProduct = cardItems.map { it.name }
        Toast.makeText(applicationContext, "Added Product : $namesOfProduct", Toast.LENGTH_LONG).show()
    }

    private fun onAddButtonClicked(product: Product) {
        cardItems.add(product)
    }

    private fun onClickProduct(product: Product) {
        val intent = Intent(applicationContext, ProductDetailActivity::class.java)
        intent.putExtra("product", product)
        startActivity(intent)
    }

    private fun createProductList(): List<Product>{
        var products = arrayListOf<Product>()
        products.add(Product("apple", "ipad", "iPad", "$599", "dd_logo" ))
        products.add(Product("apple", "mac", "Macbook pro M3", "$2599", "dd_logo" ))
        products.add(Product("Sony", "joystick", "PS Controller 5", "$499", "dd_logo" ))
        products.add(Product("Dbrand", "keyboard", "Mechanical Keyboard", "$399", "dd_logo" ))
        products.add(Product("Microsoft", "laptop", "Surface Pro", "$1599", "dd_logo" ))
        products.add(Product("apple", "ipad", "iPad", "$599", "dd_logo" ))
        products.add(Product("apple", "mac", "Macbook pro M3", "$2599", "dd_logo" ))
        products.add(Product("Sony", "joystick", "PS Controller 5", "$499", "dd_logo" ))
        products.add(Product("Dbrand", "keyboard", "Mechanical Keyboard", "$399", "dd_logo" ))
        products.add(Product("Microsoft", "laptop", "Surface Pro", "$1599", "dd_logo" ))
        return products
    }
}

// Utility fun to get Drawable from resource
fun Context.getResource(name:String): Drawable? {
    val resID = this.resources.getIdentifier(name , "drawable", this.packageName)
    return ActivityCompat.getDrawable(this,resID)
}