package com.example.dinnerdecider

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.dinnerdecider.entity.User


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
                val user = User(txtFirstName?.text.toString(),
                    txtLastName?.text.toString(),
                    txtEmail?.text.toString(),
                    txtPassword?.text.toString(),
                    )
                register(user)
            }else{
                Toast.makeText(applicationContext,"Please provide all required info",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun register(user: User){
        val intent = Intent()
        intent.putExtra("user", user)
        setResult(Activity.RESULT_OK, intent)
        Toast.makeText(applicationContext,"Successfully registered!, Please use the credential to login.",Toast.LENGTH_SHORT).show()
        finish()
    }
}
