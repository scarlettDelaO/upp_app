package com.example.upp_app

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.upp_app.ui.screen.login.LoginScreen
import com.example.upp_app.ui.screen.main.MainScreen
import com.example.upp_app.ui.screen.register.RegisterScreen
import com.example.upp_app.ui.screen.verify.VerifyCodeScreen
import com.example.upp_app.ui.screen.welcome.WelcomeScreen
import com.example.upp_app.ui.theme.Upp_appTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Upp_appTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            LoginScreen(navController = navController)
                        }
                        composable("register") {
                            RegisterScreen(navController = navController)
                        }
                        composable("VerifyCode") {
                            VerifyCodeScreen(navController = navController)
                        }
                        composable("MainScreen") {
                            MainScreen(navController = navController)
                        }

                    }
                }
            }
        }
    }
}


