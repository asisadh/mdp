package com.example.dinnerdecider.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dinnerdecider.R

@Composable
fun WalmartLoginScreen(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,) {
        Image(
            painter = painterResource(id = R.drawable.walmart_logo),
            modifier = Modifier.height(40.dp),
            contentDescription = "Walmart Logo")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Sign in to your account")
        Spacer(modifier = Modifier.height(10.dp))
        LoginBox()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBox(){
    ElevatedCard(modifier = Modifier
        .fillMaxWidth(0.9f),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
    ){
        Column(Modifier.padding(16.dp)) {
            Text(text = "Email address (Required)")
            Spacer(modifier = Modifier.height(5.dp))
            BasicTextField(
                modifier = Modifier
                    .height(40.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp))
                    .fillMaxWidth(),
                value = "",
                onValueChange = {} )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Password (required)")
            Spacer(modifier = Modifier.height(5.dp))
            BasicTextField(
                modifier = Modifier
                    .height(40.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp))
                    .fillMaxWidth(),
                value = "",
                onValueChange = {} )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Forget Password?")
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {  }) {
                Text(text = "Sign In")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Don't have an account?")
            Spacer(modifier = Modifier.height(5.dp))
            Button( modifier = Modifier.fillMaxWidth(),
                onClick = {  }) {
                Text(text = "Create a new account")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WalmartLoginScreenPreview() {
    WalmartLoginScreen()
}