package com.example.dinnerdecider.product.entity

import java.io.Serializable

class Product(brand: String, image: String, name: String, price: String, logo:String): Serializable {

    val brand: String = brand
    val image: String = image
    val name: String = name
    val price: String = price
    val logo: String = logo
}