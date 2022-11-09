package com.datechnologies.androidtest.api

data class RawChatLog(
    val data: List<ChatLogMessageModel>
)


data class ChatLogMessageModel(
    val user_id: String,
    val name: String,
    val avatar_url: String,
    val message: String
)

