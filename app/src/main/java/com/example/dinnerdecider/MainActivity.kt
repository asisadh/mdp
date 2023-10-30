@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.dinnerdecider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dinnerdecider.ui.theme.DinnerDeciderTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private var foodMenu = arrayOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    private var currentSelection = foodMenu[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DinnerDeciderTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MenuPage( currentSelection, foodMenu)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuPage(currentSelection: String, foodMenu: Array<String>) {
    var food by remember { mutableStateOf(currentSelection) }
    var txtFood by remember { mutableStateOf("") }
    var foodMenu by remember { mutableStateOf(foodMenu) }
    Column (
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
    ){
        Column(
            modifier = Modifier
                .padding(20.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(id = R.drawable.dd_logo),
                contentDescription = stringResource(id = R.string.dd_logo_description)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(food, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                label = { Text(text = "add new Food...") },
                value = txtFood,
                onValueChange = { txtFood = it })

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = {
                    if(txtFood.isNotEmpty()){
                        food = txtFood
                        txtFood = ""
                        if (food !in foodMenu){
                            foodMenu += food
                        }
                    }
                }) {
                Text(text = "ADD FOOD")
            }

            Spacer(modifier = Modifier.height(80.dp))
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RectangleShape,
            onClick = {
                val index = foodMenu.size - 1
                val random = Random.nextInt(0, index)
                food = foodMenu[random]
            }) {
            Text(text = "DECIDE!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DinnerDeciderTheme {
        MenuPage("Hamburger", arrayOf())
    }
}