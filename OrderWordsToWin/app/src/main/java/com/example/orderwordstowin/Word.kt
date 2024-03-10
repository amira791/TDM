package com.example.orderwordstowin




data class Word(
    val value: String
)

fun getData(): List<Word> {
    val wordList = mutableListOf<Word>()
    val values = listOf(
        "A",
        "Have",
        "Great",
        "Hope",
        "Day",
        "You"
    )
    for (i in 0 until values.size) {
        wordList.add(Word(values[i]))
    }
    return wordList
}

val answers = listOf(
    4,
    3,
    5,
    1,
    6,
    2
)