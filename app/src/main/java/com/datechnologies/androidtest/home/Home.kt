package com.datechnologies.androidtest.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.datechnologies.androidtest.R
import com.datechnologies.androidtest.navigation.Header
import com.datechnologies.androidtest.navigation.Screens

@Composable
fun HomeScreen(navController: NavController) {
    Box {
            BackgroundImage()
            Header(navController, "Coding Tasks", false)
        Surface(modifier = Modifier
            .matchParentSize(),
            color = Color.White.copy(alpha = 0.0f)) {
            Box {

                Surface(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                    color = Color.White.copy(alpha = 0.0f)) {
                    Column {
                        val chat: Painter = painterResource(id = R.drawable.ic_baseline_chat_bubble_outline_24)
                        val login: Painter = painterResource(id = R.drawable.outline_lock_black_24)
                        val animation: Painter = painterResource(id = R.drawable.ic_baseline_blur_on_24)
                        Spacer(modifier = Modifier.height(214.dp))
                        MenuButton("CHAT", chat, Screens.Chat.route, navController)
                        Spacer(modifier = Modifier.height(24.dp))
                        MenuButton("LOGIN", login, Screens.Login.route, navController)
                        Spacer(modifier = Modifier.height(24.dp))
                        MenuButton("ANIMATION", animation, Screens.Animation.route, navController)
                    }
                }


            }
        }
    }
}

@Preview
@Composable
fun HeaderPreview() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(62.dp)
            .background(color = Color(0xFF0E5C89))
    ) {
        Row(
            Modifier
                .padding(horizontal = 30.dp)
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Start) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    color = Color.White,
                    text = "Coding Tasks")

            }
        }

    }

}

@Composable
fun BackgroundImage() {
        Image(modifier = Modifier
            .size(800.dp),
            painter = painterResource(id = R.drawable.gpc_background),
            contentScale = ContentScale.Crop,
            contentDescription = "city background",

        )
}

@Composable
fun MenuButton(type: String, icon: Painter, destination: String, navController: NavController) {
    Button(modifier = Modifier
        .width(530.dp)
        .height(55.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White.copy(alpha = 0.8f),
            contentColor = Color.Black
        ),
        onClick = { navController.navigate(destination) },
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(
            start = 22.dp,
            top = 16.dp,
            bottom = 16.dp
        )
    )
    {
        Row(horizontalArrangement = Arrangement.Start) {
            Icon(icon, contentDescription = "$type Icon", Modifier.size(24.dp))
            Spacer(Modifier.width(16.dp))
            Text(text = type, color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Spacer(Modifier.weight(1f))
        }

    }


}


