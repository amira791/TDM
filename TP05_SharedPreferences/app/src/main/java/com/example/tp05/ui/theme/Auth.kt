import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.tp05.R


@Composable
fun LoginScreen() {
    var username = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo")
        Text(text = "Welcome Back ")
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Login Into Your Account")

        OutlinedTextField(
            value = username.value, // Access the value property
            onValueChange = { username.value = it }, // Update the value using the value property
            label = { Text(text = "Username") },
            textStyle = TextStyle(color = Color.Black),
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password.value, // Access the value property
            onValueChange = { password.value = it }, // Update the value using the value property
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // log.i("Credential", "Username: ${username.value} Password : ${password.value}")
        }) {
            Text(text = "Login")
        }
        Text(
            text = "Forgot your Password ? ",
            modifier = Modifier.clickable { /* Handle click */ }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Or Sign In With ")
        Row(
            modifier = Modifier.fillMaxWidth().padding(40.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook",
                modifier = Modifier.size(40.dp).clickable { /* Handle click */ }
            )

            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier.size(40.dp).clickable { /* Handle click */ }
            )
            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = "Twitter",
                modifier = Modifier.size(40.dp).clickable { /* Handle click */ }
            )
        }
    }
}
