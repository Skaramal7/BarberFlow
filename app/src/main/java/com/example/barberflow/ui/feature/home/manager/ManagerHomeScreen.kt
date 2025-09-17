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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.barberflow.ui.feature.auth.AuthViewModel
import com.example.barberflow.ui.theme.Brown
import com.example.barberflow.ui.theme.PrimaryOrange
import com.example.barberflow.ui.theme.SecondaryOrange
import com.example.barberflow.ui.theme.White
import com.example.barberflow.user.Appointment
import com.example.barberflow.user.Customer
import com.example.barberflow.user.Manager
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManagerHomeScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    manager: Manager,
) {
    val name: String? = authViewModel.user!!.displayName ?: "Convidado"


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
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = { navController.navigate("barbers") }
                    ) {
                        Icon(
                            Icons.Filled.AccountBox,
                            contentDescription = "barbers",
                            tint = Brown,
                            modifier = Modifier.size(160.dp)
                        )
                    }
                    Text("Barbeiros", color = Brown)
                }

                Spacer(Modifier.width(40.dp))

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            Icons.Filled.List,
                            contentDescription = "rewind",
                            tint = Brown,
                            modifier = Modifier.size(160.dp)
                        )
                    }
                    Text("Relatórios", color = Brown)
                }
            }
        }
    }
}