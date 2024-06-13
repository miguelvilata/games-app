package com.pepisoft.heros_app.di

import com.pepisoft.heros_app.data.ApiGames
import com.pepisoft.heros_app.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiGames(retrofit: Retrofit): ApiGames {
        return retrofit.create(ApiGames::class.java) //recoge una interfaz y devuelve una implementación de la misma
    }
}