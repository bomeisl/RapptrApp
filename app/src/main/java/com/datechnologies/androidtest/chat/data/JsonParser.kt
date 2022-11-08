package com.datechnologies.androidtest.chat.data

import com.beust.klaxon.Klaxon
import com.datechnologies.androidtest.api.ChatLogMessageModel
import com.datechnologies.androidtest.api.ChatRawDataModel

class JsonParser {

    fun parseRawChatLog(json_in: String): List<ChatLogMessageModel>? {
        val result = Klaxon()
            .parse<ChatRawDataModel>(json_in)
        return result?.body
    }

    fun userId(json_in: String): Int? {
        val result = Klaxon()
            .parse<ChatLogMessageModel>(json_in)
        return result?.userId
    }

    fun avatarUrl(json_in: String): String? {
        val result = Klaxon()
            .parse<ChatLogMessageModel>(json_in)
        return result?.avatarUrl
    }

    fun username(json_in: String): String? {
        val result = Klaxon()
            .parse<ChatLogMessageModel>(json_in)
        return result?.username
    }

    fun message(json_in: String): String? {
        val result = Klaxon()
            .parse<ChatLogMessageModel>(json_in)
        return result?.message
    }

    fun chatMessaage(json_in: String): ChatLogMessageModel? {
        val result = Klaxon()
            .parse<ChatLogMessageModel>(json_in)
        return result
    }

}