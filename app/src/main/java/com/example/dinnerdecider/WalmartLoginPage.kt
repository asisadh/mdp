package com.example.dinnerdecider

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.dinnerdecider.entity.User

class WalmartLoginPage: ComponentActivity(), View.OnClickListener  {

//    lateinit var binding: ActivityMainBinding

    private val users = arrayOf(User( "Wall", "Mart", "walmart1@walmart.com","121212"),
        User("Wall", "Mart","walmart2@walmart.com","121212"),
        User("Wall", "Mart","walmart3@walmart.com","121212"),
        User("Wall", "Mart","walmart4@walmart.com","121212"),
        User("Wall", "Mart","walmart5@walmart.com","121212")
    )

    private var txtUserName: EditText? = null
    private var txtPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
        setContentView(R.layout.activity_login)
        txtUserName = findViewById(R.id.username)
        txtPassword = findViewById(R.id.password)

        val forgotPassword = findViewById<TextView>(R.id.forgot_password)
        val loginButton = findViewById<Button>(R.id.login)
        val createNewAccountButton = findViewById<Button>(R.id.signup)

        forgotPassword.setOnClickListener(this)
        loginButton.setOnClickListener(this)
        createNewAccountButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.login -> login()
            R.id.forgot_password -> redirectToForgotPasswordActivity()
            R.id.signup -> redirectToRegisterActivity()
            else -> {
                Log.v("WalmartLoginPage"," onClick: " + view?.id)
            }
        }
    }

    private fun login(){
        if(validateUsernameAndPassword()){
            redirectToShoppingCategoryActivity()
        }else{
            // print toast username and password do not match
            Toast.makeText(applicationContext,"Login Failed",Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateUsernameAndPassword(): Boolean{
        val username:String = txtUserName?.text.toString()
        val password = txtPassword?.text.toString()
        if (username.isEmpty() || password.isEmpty())
            return false
        val user = User("Wall", "Mart",username = username, password = password)
        return users.asList().contains(user)
    }

    private fun redirectToShoppingCategoryActivity(){
        val intent = Intent(this, ShoppingCategoryActivity::class.java)
        intent.putExtra("username", txtUserName?.text.toString())
        startActivity(intent)
        finish() // just to remove this activity from the list of activities in backstack.
    }

    private fun redirectToRegisterActivity(){
        val intent = Intent(this, WalmartRegisterPage::class.java)
        startActivity(intent)
    }

    private fun redirectToForgotPasswordActivity(){
        val intent = Intent(this, WalmartForgotPasswordPage::class.java)
        startActivity(intent)
    }
}
