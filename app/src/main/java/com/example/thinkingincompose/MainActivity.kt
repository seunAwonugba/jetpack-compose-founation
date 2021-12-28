package com.example.thinkingincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thinkingincompose.ui.theme.ThinkingInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThinkingInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val state = rememberSaveable {
                        mutableStateOf(0)
                    }

                    Column(modifier = Modifier.padding(8.dp)) {
                        Spacer(modifier =Modifier.height(8.dp))
                        ClickCounter(clicks = state.value, onClick = {state.value++} )
                        Spacer(modifier =Modifier.height(8.dp))

                        InputField()

                    }


                }
            }
        }
    }
}


@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("I've been clicked $clicks times")
    }
}

//state practice

@Composable
fun InputField(){
    var userInput by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = userInput,
        onValueChange = {userInput = it},
        label = { Text(text = "Firstname")},
        placeholder = { Text(text = "Firstname")},
        modifier = Modifier.fillMaxWidth()
    )
}