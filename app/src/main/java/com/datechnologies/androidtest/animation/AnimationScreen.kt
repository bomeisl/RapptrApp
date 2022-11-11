package com.datechnologies.androidtest.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.datechnologies.androidtest.R
import com.datechnologies.androidtest.navigation.Header
import kotlin.math.roundToInt

@Composable
fun AnimationScreen(navController: NavController) {
    Surface() {
        Column(horizontalAlignment = CenterHorizontally) {
            Header(navController, "Animation", true)
            Surface(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)) {
                Column(modifier = Modifier
                    .align(CenterHorizontally)
                ) {
                    AnimatedLogo()
                }

            }
            
        }

    }

}


@Composable
fun AnimatedLogo() {
    var offset_x by remember { mutableStateOf(0f) }
    var offset_y by remember { mutableStateOf(0f) }
    var alpha = remember { Animatable(1f) }
    var animate by remember { mutableStateOf(false) }


        LaunchedEffect(animate) {
            alpha.animateTo(0f, animationSpec = tween(2000))
            alpha.animateTo(1f, animationSpec = tween(2000))
    }

    Column {
        Spacer(modifier = Modifier.height(100.dp))
                Surface(modifier = Modifier
                    .offset { IntOffset(offset_x.roundToInt(), offset_y.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            offset_x += dragAmount.x
                            offset_y += dragAmount.y
                        }
                    }) {
                    Row() {
                        Spacer(modifier = Modifier.width(20.dp))
                        Image(modifier = Modifier
                            .alpha(alpha = alpha.value),
                            painter = painterResource(id = R.drawable.gpc_logo),
                            contentDescription = "D+A Logo"
                        )
                    }
                    }
                        }
            Spacer(modifier = Modifier.height(400.dp))
        Button(modifier = Modifier
            .width(400.dp)
            .height(60.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0E5C89),

                ),
            onClick = { animate = !animate },
        ) {
            Text(color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                text = "FADE IN")
        }
           
}



//Animations

