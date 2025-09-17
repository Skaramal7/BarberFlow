package com.example.barberflow.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.barberflow.ui.feature.auth.AuthViewModel
import com.example.barberflow.ui.feature.auth.SignInScreen
import com.example.barberflow.ui.feature.auth.SignUpScreen
import com.example.barberflow.ui.feature.home.BarberHomeScreen
import com.example.barberflow.ui.feature.home.customer.NewAppointmentScreen
import com.example.barberflow.ui.feature.home.manager.AddBarberScreen
import com.example.barberflow.ui.feature.home.manager.BarbersScreen
import com.example.barberflow.ui.feature.home.manager.ManagerHomeScreen
import com.example.barberflow.ui.feature.profile.ProfileScreen
import com.example.barberflow.user.Barber
import com.example.barberflow.user.Customer
import com.example.barberflow.user.Manager

@Composable
fun BFNavHost(
    authViewModel: AuthViewModel,
    customer: Customer,
    barber: Barber,
    manager: Manager
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "signin") {
        composable("signin"){
            SignInScreen(navController, authViewModel)
        }

        composable("signup"){
            SignUpScreen(navController, authViewModel)
        }

//        composable("home"){
//            HomeScreen(navController, authViewModel, customer)
//        }
//        composable("home"){
//            BarberHomeScreen(navController, authViewModel, barber)
//        }
        composable("home"){
            ManagerHomeScreen(navController, authViewModel, manager)
        }

        composable("addbarber"){
            AddBarberScreen(navController, authViewModel)
        }

        composable("profile"){
            ProfileScreen(navController, authViewModel)
        }

        composable("newappointment"){
            NewAppointmentScreen(navController, authViewModel, customer)
        }

        composable("barbers"){
            BarbersScreen(navController, authViewModel)
        }
    }
}