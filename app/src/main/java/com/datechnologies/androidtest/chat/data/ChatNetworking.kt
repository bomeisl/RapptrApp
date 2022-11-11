package com.datechnologies.androidtest.chat.data

import com.beust.klaxon.Klaxon
import com.datechnologies.androidtest.api.ChatLogMessageModel
import com.datechnologies.androidtest.api.RawChatLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class ChatNetworking {

    suspend fun chatDataRetrieval(): String {
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()

            val request = Request.Builder()
                .url("http://dev.rapptrlabs.com/Tests/scripts/chat_log.php")
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                return@withContext response.body!!.string()

            }
        }
    }

}
