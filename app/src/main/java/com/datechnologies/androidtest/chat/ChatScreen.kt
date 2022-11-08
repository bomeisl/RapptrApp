package com.datechnologies.androidtest.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.datechnologies.androidtest.api.ChatLogMessageModel
import com.datechnologies.androidtest.navigation.Header


@Composable
fun ChatScreen(
    navController: NavController,
    chatViewModel: ChatViewModel = viewModel(),
    chatLogList: String = chatViewModel.data,
) {
    Column() {
        Header(navController, "Chat", true)
//        LazyColumn {
//            items(chatLogList) { chat ->
//                chat.username?.let { Text(text = it) }
//            }
        //}
        Text(text = chatLogList)
        }
    }



    @Composable
    fun ChatCard(chatLogMessageModel: ChatLogMessageModel) {
        Surface() {
            Row() {
                Surface(
                    shape = CircleShape
                ) {

                }
                Column() {
                    chatLogMessageModel.username?.let { Text(text = it) }
                    chatLogMessageModel.message?.let { Text(text = it) }
                }

            }
        }
    }


