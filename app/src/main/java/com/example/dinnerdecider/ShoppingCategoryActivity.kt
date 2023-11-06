package com.example.dinnerdecider

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class ShoppingCategoryActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_activity)

        val username = intent.getStringExtra("username")
        val txtWelcome: TextView = findViewById(R.id.welcomeTxt)
        txtWelcome.text = "Welcome ${username ?:"Guest"}"
    }

    fun categoryClicked(view: View) {
        Toast.makeText(this, "You have chosen the ${view.tag} category of shopping", Toast.LENGTH_SHORT).show()
    }
}