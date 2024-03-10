import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp2.R
import java.time.format.TextStyle


@Composable
fun TakePhoto() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.a),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Amira's World",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = androidx.compose.ui.text.TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Camera Name", modifier = Modifier.padding(start = 8.dp))
            var cameraName by remember { mutableStateOf("Enter camera name") }
            var cameraSettings by remember { mutableStateOf("Enter camera settings") }
            var isFocused by remember { mutableStateOf(false) }

            BasicTextField(
                value = TextFieldValue(cameraName),
                onValueChange = { cameraName = it.text },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .onFocusChanged { isFocused = it.isFocused },
            )

            Text(
                text = "Settings",
                modifier = Modifier.padding(start = 8.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(color = if (isFocused) Color.Black else Color.Gray)
                    .padding(start = 8.dp, end = 8.dp)
            )

            BasicTextField(
                value = TextFieldValue(cameraSettings),
                onValueChange = { cameraSettings = it.text },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .onFocusChanged { isFocused = it.isFocused },
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(color = if (isFocused) Color.Black else Color.Gray)
                    .padding(start = 8.dp, end = 8.dp)
            )

            Text(
                text = "Description: here is the best camra, here is the best camra, here is the best camra" +
                        "here is the best camra, here is the best camra, here is the best camra .",
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = { /* Handle Discard button click */ }) {
            Text("Discard")
        }
        Spacer(modifier = Modifier.width(16.dp)) // Spacer between buttons
        Button(onClick = { /* Handle Upload button click */ }) {
            Text("Upload")
        }
    }
    }
