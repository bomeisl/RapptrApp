package com.datechnologies.androidtest.chat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beust.klaxon.Klaxon
import com.datechnologies.androidtest.api.ChatLogMessageModel
import com.datechnologies.androidtest.api.RawChatLog
import com.datechnologies.androidtest.chat.data.ChatNetworking
import com.datechnologies.androidtest.chat.data.JsonParser
import kotlinx.coroutines.launch

class ChatViewModel(): ViewModel() {
    val chatNetworking = ChatNetworking()
    var data by mutableStateOf("")
    var message = listOf<ChatLogMessageModel>()

    init {
        fetchChatData()
    }

    fun fetchChatData() {
        viewModelScope.launch {
            data = chatNetworking.chatDataRetrieval()
            message = chat(data)
        }
    }

    fun chat(json_in: String): List<ChatLogMessageModel> {
        val result = Klaxon()
            .parse<RawChatLog>(json_in)
        return result!!.data
    }



}