package com.tariq.customcomposeratingbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.tariq.customcomposeratingbar.ui.theme.CustomComposeRatingBarTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomComposeRatingBarTheme {

                var rating by remember { mutableStateOf(0.0) }
                var inputValue by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Title
                    Text(
                        text = "Compose Rating Widget",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.size(40.dp))

                    // Input Field
                    TextField(
                        value = inputValue,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = {
                            inputValue = it
                            if (it.isEmpty()) {
                                rating = 0.0
                            }
                        },
                    )

                    Spacer(modifier = Modifier.size(20.dp))

                    // Change Rating Button
                    Button(onClick = {
                        val enteredValue = inputValue.toDoubleOrNull() ?: 0.0
                        rating += enteredValue
                    }) {
                        Text("Change Rating")
                    }


                    Spacer(modifier = Modifier.size(20.dp))

                    // Rating Widget
                    RatingWidget(
                        modifier = Modifier.padding(5.dp),
                        rating = rating
                    )
                }
            }

        }
    }

}


