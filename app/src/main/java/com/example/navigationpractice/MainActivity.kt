package com.example.navigationpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationpractice.ui.theme.NavigationPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     Myapp()
                }
            }
        }
    }
}

@Composable
fun Myapp(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen",){
        composable("firstscreen"){
            FirstScreen{name->
                navController.navigate("secondscreen/$name")
            }
        }
        composable("secondscreen/{name}"){
            val name=it.arguments?.getString("name") ?: "no name "
            SecondScreen(name){
                navController.navigate("firstscreen")
            }
        }
    }
}