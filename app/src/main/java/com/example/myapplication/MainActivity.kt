package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

private val BackgroundColor = Color(0xFFF7F8FA)
private val InstallBlue = Color(0xFF2F6FEB)
private val CheckBlue = Color(0xFF4A86F7)

class StoreViewModel : ViewModel() {
    val sections: List<StoreSection> = SampleApps.sections

    fun appsInSection(sectionId: String): List<StoreApp> =
        SampleApps.appsInSection(sectionId)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = BackgroundColor
                ) { innerPadding ->
                    StoreScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun StoreScreen(
    modifier: Modifier = Modifier,
    viewModel: StoreViewModel = viewModel()
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        viewModel.sections.forEach { section ->
            item(key = "title_${section.id}") {
                Text(
                    text = section.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 12.dp)
                )
            }
            item(key = "content_${section.id}") {
                val apps = viewModel.appsInSection(section.id)
                if (section.type == "list") {
                    ListSection(apps)
                } else {
                    GridSection(apps)
                }
            }
        }
    }
}

@Composable
fun ListSection(apps: List<StoreApp>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(apps, key = { it.id }) { app ->
            BannerAppItem(app = app, modifier = Modifier.fillParentMaxWidth(0.92f))
        }
    }
}

@Composable
fun BannerAppItem(app: StoreApp, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(app.bannerRes),
            contentDescription = app.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(24.dp))
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            AppIcon(app)
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = app.title,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Row(modifier = Modifier.padding(top = 6.dp)) {
                    Text(text = app.category, color = Color.DarkGray)
                    Text(
                        text = app.rating.toString(),
                        color = Color.DarkGray,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {},
                shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp, topEnd = 4.dp, bottomEnd = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = InstallBlue),
                contentPadding = PaddingValues(horizontal = 12.dp),
                modifier = Modifier.height(36.dp)
            ) {
                Text(text = "Install", color = Color.White)
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(
                onClick = {},
                shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp, topEnd = 20.dp, bottomEnd = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = CheckBlue),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(width = 40.dp, height = 36.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.check_24dp),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun GridSection(apps: List<StoreApp>) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(272.dp)
    ) {
        items(apps, key = { it.id }) { app ->
            GridAppItem(app)
        }
    }
}

@Composable
fun GridAppItem(app: StoreApp) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.width(340.dp)
    ) {
        AppIcon(app)
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = app.title,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(text = app.category, color = Color.DarkGray)
            Text(text = app.rating.toString(), color = Color.DarkGray)
        }
    }
}

@Composable
fun AppIcon(app: StoreApp) {
    Image(
        painter = painterResource(app.iconRes),
        contentDescription = app.title,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(72.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun StoreScreenPreview() {
    MyApplicationTheme {
        StoreScreen()
    }
}
