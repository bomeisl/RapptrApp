package com.datechnologies.androidtest.api

data class ChatLogMessageModel(
    var userId: Int = 0,
    var avatarUrl: String? = null,
    var username: String? = null,
    var message: String? = null
)

data class ChatRawDataModel(
    var header: String = "data",
    var body: List<ChatLogMessageModel>
)