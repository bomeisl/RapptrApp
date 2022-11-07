package com.datechnologies.androidtest.login

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import androidx.lifecycle.Observer
import kotlinx.coroutines.delay

class LoginNetworking {

    suspend fun loginOutput(email: String, password: String) = withContext(Dispatchers.IO) {
        postLogin(email, password)
    }


    fun postLogin(
        email: String,
        password: String
    ) {
        val client = OkHttpClient()

        val formBody = FormBody.Builder()
            .add("email", email)
            .add("password", password)
            .build()
        val request = Request.Builder()
            .url("https://en.wikipedia.org/w/index.php")
            .post(formBody)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            println(response.body!!.string())

        }
    }
}
