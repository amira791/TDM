import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navifationexample.ui.theme.Destination
import com.example.tp05.R
import com.siviwe.composeapp.data.Reservation






@Composable
fun ResList(
    reservations: List<Reservation>,
    isLoggedIn: Boolean,
    navHostController: NavHostController
) {
    if (isLoggedIn) {
        LazyColumn {
            items(reservations.size) { index ->
                ResItem(res = reservations[index])
            }
        }
    } else {
        Text(
            text = "Please log in to view reservations.",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Button(
            onClick = { navHostController.navigate(Destination.Ecran4.route) },

            colors = ButtonDefaults.buttonColors(Color(0xFFFF5722)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            Text("Log In")
        }

    }
}

@Composable
fun ResItem(res: Reservation) {

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.res),
                contentDescription = "Image",
                modifier = Modifier.size(64.dp).clickable { /* Handle click */ },
                contentScale = ContentScale.Crop
            )

        }
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
            Text(
                text = res.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = res.name,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = res.time,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                color = Color.Gray
            )
        }
    }
}