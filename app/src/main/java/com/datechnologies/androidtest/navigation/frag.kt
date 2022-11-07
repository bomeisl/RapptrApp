package com.datechnologies.androidtest.navigation

sealed class Screens(val route: String) {
    object Home: Screens("home_screen")
    object Login: Screens("login_screen")
    object Animation: Screens("animation_screen")
    object Chat: Screens("chat_screen")
}