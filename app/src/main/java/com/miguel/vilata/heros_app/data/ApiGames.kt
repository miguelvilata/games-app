package com.miguel.vilata.heros_app.data

import com.miguel.vilata.heros_app.model.GamesModel
import com.miguel.vilata.heros_app.model.SingleGameModel
import com.miguel.vilata.heros_app.util.Constants.Companion.API_KEY
import com.miguel.vilata.heros_app.util.Constants.Companion.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiGames {

    @GET(END_POINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>

    @GET("$END_POINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value = "id") id: Int): Response<SingleGameModel>
}
