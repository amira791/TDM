import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable


@Composable
fun DisplayHome (navController : NavHostController)
{
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    )

    {
        Button(onClick = {navController.navigate(Destination.Home.route)}
        )
        {
            Text ("Home")
        }

    }

}