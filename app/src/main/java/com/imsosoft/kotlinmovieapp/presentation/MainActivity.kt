package com.imsosoft.kotlinmovieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.imsosoft.kotlinmovieapp.presentation.ui.theme.KotlinMovieAppTheme
import com.imsosoft.kotlinmovieapp.presentation.views.screens.MovieDetailScreen
import com.imsosoft.kotlinmovieapp.presentation.views.screens.MovieScreen
import com.imsosoft.kotlinmovieapp.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinMovieAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.MovieScreen.route ) {

                        composable(route = Screen.MovieScreen.route) {
                            MovieScreen(navController = navController)
                        }
                        composable(route = Screen.MovieDetailScreen.route+"/{${Constants.IMDB_ID}}") {
                            MovieDetailScreen()
                        }

                    }

                }
            }
        }
    }
}

