package com.datechnologies.androidtest.chat.data

import com.beust.klaxon.Klaxon
import com.beust.klaxon.json
import com.beust.klaxon.token.EOF
import com.datechnologies.androidtest.api.ChatLogMessageModel
import com.datechnologies.androidtest.api.RawChatLog

//import com.datechnologies.androidtest.api.ChatRawDataModel

class JsonParser {

//    fun parseRawChatLog(json_in: String): String {
//        val input = json_in.trimIndent()
//        val result = Klaxon().parse<ChatLogMessageModel>(input)
//        return result?.data!!
//
//    }

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