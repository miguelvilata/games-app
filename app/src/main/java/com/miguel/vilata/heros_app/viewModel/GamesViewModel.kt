package com.miguel.vilata.heros_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguel.vilata.heros_app.model.GameList
import com.miguel.vilata.heros_app.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val repository: GamesRepository): ViewModel() {

    private val _games = MutableStateFlow<List<GameList>>(emptyList())
    val games = _games.asStateFlow()

    init {
        fetchGames()
    }

    private fun fetchGames() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getGames()
                _games.value = result ?: emptyList()
            }
        }
    }
}