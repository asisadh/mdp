package com.example.dinnerdecider

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class WalmartForgotPasswordPage: ComponentActivity() {

    private var txtEmail: EditText? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        txtEmail = findViewById(R.id.txtEmail)

        val submitButton = findViewById<Button>(R.id.submit_button)

        submitButton.setOnClickListener {
            sendEmail()
        }
    }

    private fun sendEmail(){
        if(txtEmail?.text.toString().isNotEmpty())
            sendPasswordInEmail()
        else
            Toast.makeText(this, "Please provide a valid email address", Toast.LENGTH_SHORT).show()
    }

    // not an actual implementation
    // but could have passed the list from login activity
    // list of the stored user in intent
    // then filter out that
    // will do that later
    // could not finish that in the deadline.
    private fun sendPasswordInEmail(){
        val email = Intent(Intent.ACTION_SEND)
        email.putExtra(Intent.EXTRA_EMAIL, txtEmail?.text.toString())
        email.putExtra(Intent.EXTRA_SUBJECT, "You have requested your password.")
        email.putExtra(Intent.EXTRA_TEXT, android.R.id.message)

        //need this to prompts email client only

        //need this to prompts email client only
        email.type = "message/rfc822"

        startActivity(Intent.createChooser(email, "Choose an Email client :"))
    }
}