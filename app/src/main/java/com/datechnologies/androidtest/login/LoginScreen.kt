package com.datechnologies.androidtest.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.datechnologies.androidtest.R
import com.datechnologies.androidtest.navigation.Header
import okhttp3.OkHttpClient
import kotlin.math.log

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel()
) {
    Box {
        BackgroundImage()
        Column {
            Header(navController = navController, "Login", true)
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                TextField(
                    placeholder = { Text(text = "email", fontSize = 16.sp, color = Color(0xFF5F6063)) },
                    value = loginViewModel.email,
                    onValueChange = {
                        loginViewModel.email = it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        unfocusedIndicatorColor = Color(0xFF7B7B7E),
                        focusedIndicatorColor = Color(0xFF0E5C89)
                    ),
                    textStyle = TextStyle(Color.Black)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    placeholder = { Text(text = "password", fontSize = 16.sp, color = Color(0xFF5F6063)) },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        unfocusedIndicatorColor = Color(0xFF7B7B7E),
                        focusedIndicatorColor = Color(0xFF0E5C89)

                    ),
                    value = loginViewModel.password,
                    onValueChange = {
                        loginViewModel.password = it
                    }
                )
                Spacer(modifier = Modifier.height(26.dp))
                Button(
                    modifier = Modifier
                        .width(300.dp)
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF0E5C89),
                    ),
                    onClick = { loginViewModel.login() }) {
                    Text(
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        text = "LOGIN"
                    )
                }
                if (loginViewModel.message_dialog) {
                    MessageDialog(loginViewModel, navController)
                }
            }
        }
    }
}




@Composable
fun BackgroundImage() {
    Image(modifier = Modifier
        .size(800.dp),
        painter = painterResource(id = R.drawable.gpc_sunset),
        contentScale = ContentScale.Crop,
        contentDescription = "sunset",

        )
}

@Composable
fun LoginTextField(field: String) {
    TextField(
        value = TextFieldValue("username"),
        onValueChange = {

        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
        ),
        textStyle = TextStyle(Color.Black)
    )
}


@Composable
fun MessageDialog(loginViewModel: LoginViewModel, navController: NavController) {
    AlertDialog(
        onDismissRequest = {
            var message_dialog = false
        },
        title = {
            Text(text = loginViewModel.code)
        },
        text = {
            Text(
                text = loginViewModel.message
            )
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { loginViewModel.alert_dialog_button(navController) }
                ) {
                    Text("OK")
                }
            }
        }
    )

}
