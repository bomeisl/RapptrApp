package com.datechnologies.androidtest.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.datechnologies.androidtest.MainActivity
import com.datechnologies.androidtest.navigation.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

class LoginViewModel(): ViewModel() {
    val network = LoginNetworking()
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var login_response by mutableStateOf("")
    var message_dialog by mutableStateOf(false)
    val json_parser = JsonParser()
    var code by mutableStateOf("")
    var message by mutableStateOf("")

    fun login() {
        viewModelScope.launch {
            login_response = network.loginOutput(email, password)
            code = json_parser.code(login_response).toString()
            message = json_parser.message(login_response).toString()
        }
        message_dialog = !message_dialog

    }

    fun alert_dialog_button(navController: NavController) {
        message_dialog = false
        if (code == "Success") navController.navigate(Screens.Home.route)
    }
}