package com.miguel.vilata.heros_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.miguel.vilata.heros_app.ui.theme.HerosappTheme
import com.miguel.vilata.heros_app.viewModel.GamesViewModel
import com.miguel.vilata.heros_app.views.HomeView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: GamesViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            HerosappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeView(viewModel)
                }
            }
        }
    }
}
