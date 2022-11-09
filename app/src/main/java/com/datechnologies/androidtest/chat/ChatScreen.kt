package com.datechnologies.androidtest.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.datechnologies.androidtest.R
import com.datechnologies.androidtest.api.ChatLogMessageModel
import com.datechnologies.androidtest.chat.data.JsonParser
import com.datechnologies.androidtest.navigation.Header


@Composable
fun ChatScreen(
    navController: NavController,
    chatViewModel: ChatViewModel = viewModel(),
) {
    Column() {
        Header(navController, "Chat", true)
        LazyColumn {
            items(chatViewModel.message) { chat ->
                ChatCard(chatLogMessageModel = chat) 
                Spacer(modifier = Modifier.height(10.dp))
            }
            }
        }
    }





    @Composable
    fun ChatCard(chatLogMessageModel: ChatLogMessageModel) {
        Surface() {
            Row() {
                Surface(modifier = Modifier
                    .padding(7.dp),
                    shape = CircleShape
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(chatLogMessageModel.avatar_url.toString())
                            .crossfade(true)
                            .build(),
                        //placeholder = painterResource(R.drawable.placeholder),
                        contentDescription = "", //stringResource(R.string.description),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                    )

                }
                Column() {
                    Text(text = chatLogMessageModel.name.toString())
                    Text(text = chatLogMessageModel.message.toString())
                }

            }
        }
    }


