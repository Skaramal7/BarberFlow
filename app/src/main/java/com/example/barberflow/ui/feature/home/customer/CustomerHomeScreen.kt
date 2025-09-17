package com.example.barberflow.ui.feature.home.customer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.barberflow.ui.feature.auth.AuthViewModel
import com.example.barberflow.ui.theme.Brown
import com.example.barberflow.ui.theme.PrimaryOrange
import com.example.barberflow.ui.theme.SecondaryOrange
import com.example.barberflow.ui.theme.White
import com.example.barberflow.user.Customer


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    customer: Customer,
) {
    val name: String? = authViewModel.user!!.displayName ?: "Convidado"

    var appointment by remember {
        mutableStateOf(customer.appointment)
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
                title = { Text(text = "Bem vinda(o), $name") },
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

            appointment?.let {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth(0.9f)
                        .height(120.dp)
                        .background(Brown),
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Icon(
                        Icons.Filled.DateRange,
                        contentDescription = "appointment",
                        tint = PrimaryOrange,
                        modifier = Modifier.size(70.dp)
                    )

                    Column {
                        Text("Seu próximo agendamento", color = White)

                        Text("Quando: ${appointment.date.toString()}", color = White)

                        Text("Barbeiro: ${appointment.barber.name}", color = White)
                    }
                }
                Spacer(Modifier.height(20.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .clickable(
                        onClick = {
                            navController.navigate("newappointment")
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = "newappointment",
                    tint = Brown,
                    modifier = Modifier.size(70.dp)
                )

                Text("Novo agendamento", color = Brown, fontSize = 20.sp)
            }
        }
    }
}