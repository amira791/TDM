import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.navifationexample.ui.theme.Destination

@Composable
fun DisplayEcran3 (navHostController: NavHostController)
{
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text ("This is the 3rd Screen ")
        Button(onClick = {navHostController.navigate(Destination.Ecran3.route)}
        )
        {
            Text ("Ecran3")
        }

    }
}