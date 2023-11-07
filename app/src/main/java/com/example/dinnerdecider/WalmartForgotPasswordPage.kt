package com.example.dinnerdecider

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.dinnerdecider.entity.User

class WalmartForgotPasswordPage: ComponentActivity() {

    private var txtEmail: EditText? = null
    private var users: Array<User> = arrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        users = intent.getSerializableExtra("users") as Array<User>

        txtEmail = findViewById(R.id.txtEmail)

        val submitButton = findViewById<Button>(R.id.submit_button)

        submitButton.setOnClickListener {
            sendEmail()
        }
    }

    private fun sendEmail(){
        if(txtEmail?.text.toString().isNotEmpty())
            sendIfEmailExist()
        else
            Toast.makeText(this, "Please provide a valid email address", Toast.LENGTH_SHORT).show()
    }

    private fun sendIfEmailExist(){
        val user: User? = users.find { user -> user.email == txtEmail?.text.toString() }
        if (user != null){
            sendPasswordInEmail(user.email)
        }else{
            Toast.makeText(this, "Could not found the email address", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendPasswordInEmail(email: String){
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "You have requested your password.")
        emailIntent.putExtra(Intent.EXTRA_TEXT, android.R.id.message)
        emailIntent.type = "message/rfc822"
        startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"))
    }
}
