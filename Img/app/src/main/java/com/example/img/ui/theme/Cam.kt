import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.img.MainActivity2


@Composable

fun LaunchCam() {
    val  context = LocalContext.current
    val result = remember { mutableStateOf<Bitmap?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { it ->
        result.value = it
    }

    Column(
        horizontalAlignment = Alignment.End,
    ) {
        Button(
            onClick = {

                launcher.launch(null)
            }
        ) {
            Text("Take Picture")
        }
        Button(onClick = { val intent = Intent (context, MainActivity2::class.java)
            context.startActivity(intent) }) {
            Text("Display Activity 2")
            //(context as Activity).finish()

            
        }


        result.value?.let { it ->
            Image(
                it.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                
              

            )
        }
    }
}

