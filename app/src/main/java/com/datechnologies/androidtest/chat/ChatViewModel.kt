package com.datechnologies.androidtest.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.datechnologies.androidtest.api.ChatLogMessageModel
import com.datechnologies.androidtest.chat.data.ChatNetworking
import com.datechnologies.androidtest.chat.data.JsonParser
import kotlinx.coroutines.launch

class ChatViewModel(): ViewModel() {
    val chatNetworking = ChatNetworking()
    val json = JsonParser()
    var data = ""

    init {
        fetchChatData()

    }



    fun fetchChatData() {
        viewModelScope.launch {
            data = chatNetworking.chatDataRetrieval()
        }
    }

//    fun parseChatData() {
//        data = json.parseRawChatLog(data).toString()
//    }

}