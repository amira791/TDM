import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext

@Composable
fun LaunchMap() {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.End,
    ) {
        Button(
            onClick = {
                val latitude = 28.0268755// Example latitude
                val longitude = 1.6528399999999976 // Example longitude
                val data = Uri.parse("geo:$latitude,$longitude")
                val intent = Intent(Intent.ACTION_VIEW, data)
                intent.setPackage("com.google.android.apps.maps") // Specify Google Maps package
                context.startActivity(intent)
            }
        ) {
            Text("MAP")
        }
    }
}

