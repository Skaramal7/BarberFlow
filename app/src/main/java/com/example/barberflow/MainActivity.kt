package com.example.barberflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.barberflow.navigate.BFNavHost
import com.example.barberflow.ui.feature.auth.AuthViewModel
import com.example.barberflow.ui.theme.BarberFlowTheme
import com.example.barberflow.user.Barber
import com.example.barberflow.user.Customer
import com.example.barberflow.user.Manager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        var customer : Customer = Customer(123, "Testerson", "349912345678", "teste@gmail.com")
        var barber = Barber(123, "Testerson", "teste@gmail.com", null, 8, 18)
        var manager = Manager(123, "Testerson", "teste@gmail.com", null)

        setContent {
            BarberFlowTheme {
                BFNavHost(authViewModel, customer, barber, manager)
            }
        }
    }
}