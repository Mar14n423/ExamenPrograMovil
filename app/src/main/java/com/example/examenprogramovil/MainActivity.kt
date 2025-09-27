package com.example.examenprogramovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.examenprogramovil.navigation.AppNavigation
import com.example.examenprogramovil.ui.theme.ExamenPrograMovilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()





            //ExamenPrograMovilTheme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //GithubScreen(modifier = Modifier.padding(innerPadding))
               //     SignInPage()
             //   }
            //}

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExamenPrograMovilTheme {
        Greeting("Android")
    }
}