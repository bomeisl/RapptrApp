package com.datechnologies.androidtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.datechnologies.androidtest.animation.AnimationScreen
import com.datechnologies.androidtest.chat.ChatScreen
import com.datechnologies.androidtest.home.HomeScreen
import com.datechnologies.androidtest.login.LoginScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Home.route)
    {
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screens.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screens.Animation.route) {
            AnimationScreen(navController)
        }
        composable(route = Screens.Chat.route) {
            ChatScreen(navController)
        }
    }
}