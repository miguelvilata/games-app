package com.pepisoft.heros_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pepisoft.heros_app.navigation.NavManager
import com.pepisoft.heros_app.ui.theme.HerosappTheme
import com.pepisoft.heros_app.viewModel.GamesViewModel
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
                    NavManager(viewModel)
                }
            }
        }
    }
}
