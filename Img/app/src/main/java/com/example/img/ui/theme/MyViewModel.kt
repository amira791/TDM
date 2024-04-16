package com.example.img.ui.theme



import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
class MyVModel:ViewModel() {
    val counter = mutableStateOf(0)
    //val list2 = mutableListOf(1,2,3)
    //val list = mutableStateOf(list2)
    // lorsque on ajoute des elemnts list2.add() => dans ce cas lis wont change car on est entraine d'utiliser la meme refernce
    // solution : val list = mutableListOf(list2)
    fun count() {
        counter.value+=1
    }
}

