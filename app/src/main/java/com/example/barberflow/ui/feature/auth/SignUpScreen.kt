package com.example.barberflow.ui.feature.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.barberflow.R
import com.example.barberflow.ui.theme.Blue
import com.example.barberflow.ui.theme.Gray
import com.example.barberflow.ui.theme.LightGray
import com.example.barberflow.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var type by remember {
        mutableStateOf("")
    }

    var expanded by remember { mutableStateOf(false) }
    val options: List<String> = listOf("Barbeiro", "Cliente", "Gerente")
    val textFieldState = rememberTextFieldState(options[0])
    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Autheticated -> {
                navController.navigate("home")
            }

            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message,
                Toast.LENGTH_SHORT
            ).show()

            else -> Unit
        }
    }

    Scaffold (
        modifier = Modifier,

        ) { paddingValues ->

        Column (
            modifier = Modifier
                .fillMaxSize()
                .consumeWindowInsets(paddingValues)
                .background(Gray)
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50f))
                    .size(140.dp)
                    .background(Blue),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo", Modifier.size(110.dp))
            }

            Spacer(Modifier.height(50.dp))

            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(60.dp))
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                //Spacer(Modifier.height(15.dp))

                Text(
                    text = "Cadastro",
                    fontWeight = FontWeight.Black,
                    color = Gray,
                    fontSize = 30.sp
                )

                Spacer(Modifier.height(30.dp))

                Text(
                    text = "Nome", color = Gray,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 28.dp)
                )
                Spacer(Modifier.height(7.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(55.dp),
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text("Testerson Silva", color = Gray) },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Gray,
                        unfocusedTextColor = Gray,
                        focusedIndicatorColor = LightGray,
                        unfocusedIndicatorColor = LightGray,
                        cursorColor = Blue,
                        unfocusedContainerColor = LightGray,
                        focusedContainerColor = LightGray
                    ),
                    shape = RoundedCornerShape(30f)
                )

                Spacer(Modifier.height(20.dp))

                Text(
                    text = "E-mail", color = Gray,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 28.dp)
                )
                Spacer(Modifier.height(7.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(55.dp),
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("exemplo@email.com", color = Gray) },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Gray,
                        unfocusedTextColor = Gray,
                        focusedIndicatorColor = LightGray,
                        unfocusedIndicatorColor = LightGray,
                        cursorColor = Blue,
                        unfocusedContainerColor = LightGray,
                        focusedContainerColor = LightGray
                    ),
                    shape = RoundedCornerShape(30f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                Spacer(Modifier.height(20.dp))

                Text(
                    text = "Senha", color = Gray,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 28.dp)
                )
                Spacer(Modifier.height(7.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(55.dp),
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("********", color = Gray) },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Gray,
                        unfocusedTextColor = Gray,
                        focusedIndicatorColor = LightGray,
                        unfocusedIndicatorColor = LightGray,
                        cursorColor = Blue,
                        unfocusedContainerColor = LightGray,
                        focusedContainerColor = LightGray
                    ),
                    shape = RoundedCornerShape(30f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(Modifier.height(30.dp))

                Button(
                    onClick = { authViewModel.signup(name, email, password) },
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Gray,
                        contentColor = White,
                        disabledContainerColor = LightGray,
                        disabledContentColor = Gray
                    ),
                    shape = RoundedCornerShape(30f),
                    enabled = (name.length >= 3 && email.length >= 1 && password.length >= 8)
                ) {
                    Text(text = "Entrar", fontSize = 18.sp, color = White)
                }

                Spacer(Modifier.height(5.dp))

                TextButton(
                    onClick = { navController.navigate("signin") },

                    ) {
                    Text("Já tem uma conta?", color = Blue, fontSize = 15.sp)
                }
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(navController = NavHostController(LocalContext.current), authViewModel = AuthViewModel())
}