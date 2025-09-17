package com.example.barberflow.ui.feature.home.manager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.barberflow.ui.feature.auth.AuthViewModel
import com.example.barberflow.ui.theme.Blue
import com.example.barberflow.ui.theme.Brown
import com.example.barberflow.ui.theme.Gray
import com.example.barberflow.ui.theme.LightGray
import com.example.barberflow.ui.theme.PrimaryOrange
import com.example.barberflow.ui.theme.SecondaryOrange
import com.example.barberflow.ui.theme.White
import com.example.barberflow.user.Appointment
import com.example.barberflow.user.Barber
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBarberScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    var rstring by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp)),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Brown,
                    titleContentColor = White
                ),
                title = { Text(text = "Novo Barbeiro") },
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp)),
                containerColor = Brown,
                contentColor = White,
                actions = {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ){
                        IconButton(onClick = { navController.navigate("home") }) {
                            Icon(
                                Icons.Filled.Home,
                                contentDescription = "home",
                                tint = PrimaryOrange,
                                modifier = Modifier.size(35.dp)
                            )
                        }

                        IconButton(onClick = { navController.navigate("search") }) {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = "search",
                                tint = PrimaryOrange,
                                modifier = Modifier.size(35.dp)
                            )
                        }

                        IconButton(onClick = {  }) {
                            Icon(
                                Icons.Filled.ShoppingCart,
                                contentDescription = "checkout",
                                tint = PrimaryOrange,
                                modifier = Modifier.size(35.dp)
                            )
                        }

                        IconButton(onClick = { navController.navigate("profile") }) {
                            Icon(
                                Icons.Filled.Person,
                                contentDescription = "profile",
                                tint = PrimaryOrange,
                                modifier = Modifier.size(35.dp)
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .consumeWindowInsets(paddingValues)
                .background(SecondaryOrange)
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(0.60f)
                    .height(55.dp),
                value = rstring,
                onValueChange = { rstring = it },
                placeholder = { Text(text = "Nome", color = Gray) },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Gray,
                    unfocusedTextColor = Gray,
                    cursorColor = Blue,
                    unfocusedContainerColor = White,
                    focusedContainerColor = White
                ),
                shape = RoundedCornerShape(30f)
            )

            Spacer(Modifier.height(20.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth(0.60f)
                    .height(55.dp),
                value = rstring,
                onValueChange = { rstring = it },
                placeholder = { Text(text = "E-mail", color = Gray) },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Gray,
                    unfocusedTextColor = Gray,
                    cursorColor = Blue,
                    unfocusedContainerColor = White,
                    focusedContainerColor = White
                ),
                shape = RoundedCornerShape(30f)
            )

            Spacer(Modifier.height(20.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth(0.60f)
                    .height(55.dp),
                value = rstring,
                onValueChange = { rstring = it },
                placeholder = { Text(text = "Telefone", color = Gray) },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Gray,
                    unfocusedTextColor = Gray,
                    cursorColor = Blue,
                    unfocusedContainerColor = White,
                    focusedContainerColor = White
                ),
                shape = RoundedCornerShape(30f)
            )

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth(0.60f)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gray,
                    contentColor = White,
                    disabledContainerColor = LightGray,
                    disabledContentColor = Gray
                ),
                shape = RoundedCornerShape(30f)
            ) {
                Text(text = "Criar", fontSize = 18.sp, color = White)
            }
        }
    }
}