package com.miguel.vilata.heros_app.data

import com.miguel.vilata.heros_app.model.GamesModel
import com.miguel.vilata.heros_app.util.Constants.Companion.API_KEY
import com.miguel.vilata.heros_app.util.Constants.Companion.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiGames {

    @GET(END_POINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>

}