package com.example.dinnerdecider

import android.R.id.message
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity


class WalmartRegisterPage: ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val txtFirstName = findViewById<EditText>(R.id.firstName)
        val txtLastName = findViewById<EditText>(R.id.lastname)
        val txtEmail= findViewById<EditText>(R.id.username)
        val txtPassword = findViewById<EditText>(R.id.password)

        val signup = findViewById<Button>(R.id.signup)

        signup.setOnClickListener {
            if(txtFirstName?.text.toString().isNotEmpty() &&
                txtLastName?.text.toString().isNotEmpty() &&
                txtEmail?.text.toString().isNotEmpty() &&
                txtPassword?.text.toString().isNotEmpty()){
                register(txtEmail?.text.toString())
            }else{
                Toast.makeText(applicationContext,"Please provide all required info",Toast.LENGTH_SHORT).show()
            }
        }
    }

    // not exactly storing the user, but as user is tight coupled with login activity, need to do some workaround on that
    // to make that work
    private fun register(username: String){
        val intent = Intent(this, ShoppingCategoryActivity::class.java)
        intent.putExtra("username", username)
        startActivity(intent)
        finish()
    }

}
