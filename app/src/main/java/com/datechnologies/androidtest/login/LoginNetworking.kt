package com.datechnologies.androidtest.login

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.*
import okhttp3.MultipartBody.Companion.FORM
import okhttp3.internal.format
import java.io.IOException
import java.text.Normalizer.Form


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







