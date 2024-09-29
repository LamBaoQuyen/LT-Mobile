class Scrollpackage com.example.scrollablelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrollablelist.ui.theme.ScrollableListTheme

// Data class để chứa dữ liệu
data class ListItem(val imageRes: Int, val text: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableListTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ScrollableList(
                        items = listOf(
                            ListItem(R.drawable.image1, "Hình ảnh 1"),
                            ListItem(R.drawable.image2, "Hình ảnh 2"),
                            ListItem(R.drawable.image3, "Hình ảnh 3"),
                            ListItem(R.drawable.image4, "Hình ảnh 4")
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ScrollableList(items: List<ListItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        items(items) { item ->
            ListItemView(item)
        }
    }
}

@Composable
fun ListItemView(item: ListItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.text,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = item.text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScrollableListTheme {
        ScrollableList(
            items = listOf(
                ListItem(R.drawable.image1, "Hình ảnh 1"),
                ListItem(R.drawable.image2, "Hình ảnh 2"),
                ListItem(R.drawable.image3, "Hình ảnh 3"),
                ListItem(R.drawable.image4, "Hình ảnh 4")
            )
        )
    }
}
{
}