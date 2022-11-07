package com.datechnologies.androidtest.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.datechnologies.androidtest.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

class LoginViewModel(): ViewModel() {
    var result: String = ""
    val network = LoginNetworking()
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun login() {
        viewModelScope.launch {
            network.loginOutput(email, password)

        }

    }
}