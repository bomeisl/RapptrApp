package com.datechnologies.androidtest.chat

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                Spacer(modifier = Modifier.height(16.dp))
                ChatCard(chatLogMessageModel = chat) 

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
                    Text(
                        text = chatLogMessageModel.name.toString(),
                        fontSize = 13.sp,
                        color = Color(0xFF1B1E1F),
                        fontWeight = FontWeight.Medium
                    )
                Surface(modifier = Modifier
                    .padding(8.dp)
                    .border(1.dp, Color(0xFFEFEFEF),shape = RoundedCornerShape(8.dp))

                ) {
                        Text(modifier = Modifier
                            .padding(8.dp),
                            text = chatLogMessageModel.message.toString(),
                            fontSize = 15.sp,
                            color = Color(0xFF1B1E1F)
                            )
                    }
                }


            }
        }
    }


