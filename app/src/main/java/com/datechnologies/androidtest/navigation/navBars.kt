package com.datechnologies.androidtest.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Header(navController: NavController, screen: String, back: Boolean) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(72.dp)
            .background(color = Color(0xFF0E5C89))
    ) {
        Row(
            Modifier
                .padding(horizontal = 30.dp)
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Start) {
            Column(verticalArrangement = Arrangement.Center) {
                Row() {
                    IconButton(onClick = { navController.navigate(Screens.Home.route) }, modifier = Modifier.height(100.dp)) {
                        Row() {
                            if (back) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    tint = Color.White,
                                    contentDescription = null
                                )
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp,
                                text = screen)
                        }

                    }

                }

            }
        }

    }

}