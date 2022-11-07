package com.datechnologies.androidtest.chat

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.datechnologies.androidtest.navigation.Header

@Composable
fun ChatScreen(navController: NavController) {
    Text(text = "Chat")
    Header(navController, "Chat", true)
}