//package com.example.orderwordstowin
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun DisplayImage()
//{
//    Row(modifier = Modifier.fillMaxWidth()) {
//        Image(
//            painter = painterResource(id = R.drawable.main),
//            contentDescription = null,
//            modifier = Modifier
//                .weight(1f)
//                .height(200.dp),
//            contentScale = ContentScale.Crop
//        )
//    }
//
//    Row {
//
//        Column(
//            modifier = Modifier
//                .weight(2f)
//                .padding(8.dp)
//        ) {
//            Text(text = "Labrador retriever" ,
//                fontWeight = FontWeight.Bold, fontSize = 12.sp)
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(text = s,fontSize = 11.sp)
//        }
//    }
//}
//
//@Composable
//fun OrderWords()
//{
//    DisplayImage()
//}
//
//
//
//
//@Composable
//fun EvaluatePhrase ()
//{
//
//}