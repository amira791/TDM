import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navifationexample.ui.theme.Destination

@Composable
fun HomeScreen  (navHostController: NavHostController)
{
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text ("This is the 3rd Screen ")
        Button(onClick = {navHostController.navigate(Destination.Ecran2.route)}
        )
        {
            Text ("HomeScreen")
        }

    }
}



