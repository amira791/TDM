import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Card
import androidx.compose.material3.Divider
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

import com.example.ex03.R


//@Composable
//fun HeaderDesign() {
//    Column(modifier = Modifier.fillMaxWidth()) {
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Image(
//                painter = painterResource(id = R.drawable.header),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(216.dp),
//                contentScale = ContentScale.Fit
//            )
//
//        }
//    }
//}
@Composable
fun HeaderDesign(signUpClicked: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(216.dp),
            contentScale = ContentScale.Fit
        )

        Button(
            onClick = signUpClicked,
            colors = ButtonDefaults.buttonColors( Color.LightGray),
            shape = RoundedCornerShape(0.dp) ,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 16.dp, top = 16.dp)
        )
        {
            Text(
                text = "Sign Up",
                color = Color.Blue
            )
        }
    }
}


@Composable
fun FooterDesign() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.footer),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SocialMedia() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Sign In To Continue",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.height(2.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(20.dp), // Adjust height as needed
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(20.dp), // Adjust height as needed
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(20.dp), // Adjust height as needed
                contentScale = ContentScale.Fit
            )
        }
        Divider(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(0.8f) // Adjust the width as needed
                .align(Alignment.CenterHorizontally),
            color = Color.Gray,
            thickness = 1.dp
        )
        Text(
            text = "Or",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = TextAlign.Center
        )
    }

}



@Composable
fun LoginPage() {
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderDesign(signUpClicked = {
            // Handle sign-up button click
        })
        SocialMedia()
        Spacer(modifier = Modifier.weight(1f))
        FooterDesign()
    }
}
