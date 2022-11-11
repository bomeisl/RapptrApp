package com.datechnologies.androidtest.login

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class LoginNetworking {

    suspend fun loginOutput(email: String, password: String): String {
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()

            val formBody = FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .build()
            val request = Request.Builder()
                .url("http://dev.rapptrlabs.com/Tests/scripts/login.php")
                .post(formBody)
                .build()

            try {
                val response = client.newCall(request).execute()
                return@withContext response.body!!.string()

            } catch (e: IOException) {
                e.printStackTrace()
                return@withContext e.toString()
            }

        }
    }

}







