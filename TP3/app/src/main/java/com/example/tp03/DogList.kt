package com.example.tp03

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun displayDogs(Dogs:List<Dog>)
{
   // val context = LocalContext.try : point d'acce unique pour stocker les donnes
    LazyColumn
    { items(dogs)
        {Row (

            modifier =Modifier
                .clip(RoundedCornerShape(4.dp))
                .padding(4.dp)
                .background(Color(0xFFE0E0E0))
                .clickable {
                    Toast.makeText(this,it.name,Toast.LENGTH_SHORT).show()
                }

        ) {

            Column(modifier = Modifier.weight(1f).padding(8.dp ) {Image (painter=painterResource(id = R.drawable.d1_lab), contentDescription = null, contentScale = ContentScale.Crop );
            }
                    Column (modifier = Modifier.weight(2f) ) {
                Text (text = "sfsnjngrdfngl", fontwight = FontWeight.Bold, fontSize =  12.sp)
                Spacer (modifier = Modifier.width(8.dp))
                Text (text= s, fontSize =  11.sp)
            }
        }

        }
    }

}

it.image
        it.name
        it.description




        .aspectRatio(1f) //largeur = hauteur 2f -> largeur = 2 hauteur