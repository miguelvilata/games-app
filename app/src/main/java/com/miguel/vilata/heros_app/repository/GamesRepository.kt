package com.miguel.vilata.heros_app.repository

import com.miguel.vilata.heros_app.data.ApiGames
import com.miguel.vilata.heros_app.model.GameList
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {

    suspend fun getGames(): List<GameList>? {
        val response = apiGames.getGames()
        if (response.isSuccessful) {
            return response.body()?.results
        }

        return null
    }

}