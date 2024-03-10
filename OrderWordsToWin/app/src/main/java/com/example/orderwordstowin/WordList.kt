package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orderwordstowin.R
import com.example.orderwordstowin.Word
import com.example.orderwordstowin.answers


@Composable
fun DisplayWords() {
    val sentences = listOf(
        "great you a Hope have day" to "Hope you have a great day",
        "care yourself Take of" to "Take care of yourself",
        "better be to Try" to "Try to be better"
    )
    //great you a Hope have day
    val answers = listOf(
        "Hope you have a great day" to "Hope you have a great day",
        "Take care of yourself" to "Take care of yourself",
        "Try to be better" to "Try to be better"
    )

    var sentenceIndex by remember { mutableStateOf(0) }
    var shuffledWords by remember { mutableStateOf(listOf<String>()) }
    var sentenceBefore by remember { mutableStateOf("") }
    var sentence by remember { mutableStateOf("") }
    var score by remember { mutableStateOf(0) }
    val context = LocalContext.current



    // Function to move to the next sentence in the list
    fun nextSentence() {
        sentenceIndex = (sentenceIndex + 1) % sentences.size
        shuffledWords = sentences[sentenceIndex].first.split(" ").shuffled()

    }

    // UI composition
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        // Display image
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.main),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }

        // Spacer
        Spacer(modifier = Modifier.height(2.dp))

        // Title
        Text(
            text = "Order The Words ",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )

        // Display shuffled words
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(shuffledWords) { word ->
                Box(
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .background(Color(0xE005962E))
                        .clickable {
                            sentence += " $word"
                        }
                )

                {
                    Text(
                        text = word,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
        shuffledWords = sentences[sentenceIndex].first.split(" ")

        // Text field for user input
        TextField(
            value = sentence,
            onValueChange = { sentence = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )


        // Submit button
        Button(
            onClick = {
                val isCorrect = EvaluateSentence(sentence, answers.map { it.first })
                if (isCorrect) {
                    score += 5
                    Toast.makeText(
                        context,
                        "Bravo !!!! Vous avez obtenu 5 points, le score total est : $score points",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val correct = sentences[sentenceIndex].second
                    Toast.makeText(
                        context,
                        "The correct sentence is: '$correct'",
                        Toast.LENGTH_LONG
                    ).show()
                }
                sentence = "";
                nextSentence()
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .size(width = 200.dp, height = 60.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Submit",
                style = TextStyle(fontSize = 20.sp, color = Color.White),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

// Function to evaluate the user's input against the correct sentence
fun EvaluateSentence(input: String, answers: List<String>): Boolean {
    // Iterate over each sentence in the list
    for (sentence in answers) {
        // Check if the submitted input matches any of the sentences in the list
        if (input.trim().equals(sentence, ignoreCase = true)) {
            return true  // Return true if a match is found
        }
    }
    return false  // Return false if no match is found
}
