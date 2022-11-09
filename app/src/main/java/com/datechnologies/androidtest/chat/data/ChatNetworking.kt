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

    fun userId(json_in: String): String? {
        val result = Klaxon()
            .parse<ChatLogMessageModel>(json_in)
        return result?.user_id
    }

    fun avatarUrl(json_in: String): String? {
        val result = Klaxon()
            .parse<ChatLogMessageModel>(json_in)
        return result?.avatar_url
    }

    fun username(json_in: String): String? {
        val result = Klaxon()
            .parse<ChatLogMessageModel>(json_in)
        return result?.name
    }

    fun message(json_in: String): String? {
        val result = Klaxon()
            .parse<ChatLogMessageModel>(json_in)
        return result?.message
    }

    fun chatMessaage(json_in: String): RawChatLog {
        val result = Klaxon()
            .parse<RawChatLog>(json_in)
        return result!!
    }
}
