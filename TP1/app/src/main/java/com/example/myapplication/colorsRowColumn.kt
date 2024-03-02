
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp




@Composable
fun DisplayRect() {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ColoredBox(color = Color(0xFFFF0000))
            Spacer(modifier = Modifier.width(20.dp))
            ColoredBox(color = Color(0xFF00FF00))
            Spacer(modifier = Modifier.width(20.dp))
            ColoredBox(color = Color(0xFF0000FF))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ColoredBox2(color = Color(0xFFFFFF00))
            Spacer(modifier = Modifier.width(10.dp))
            ColoredBox2(color = Color(0xFFFFAA00))
            Spacer(modifier = Modifier.width(10.dp))
            ColoredBox2(color = Color(0xFFFF00FF))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ColoredBox2(color = Color(0xFF0055FF)) {
                ColoredBox2(color = Color(0xFF0099FF)) {
                    ColoredBox2(color = Color(0xFF00CCFF))
                }
            }
        }
    }
}

@Composable
fun ColoredBox2(color: Color, content: @Composable () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color)
            .size(100.dp)

    ) {
        content()
    }
}

@Composable
fun ColoredBox(color: Color, content: @Composable () -> Unit = {}) {
    Box(
        modifier = Modifier
            .background(color)
            .size(100.dp)

    ) {
        content()
    }
}