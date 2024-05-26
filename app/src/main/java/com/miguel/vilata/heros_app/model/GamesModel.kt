package com.miguel.vilata.heros_app.model

data class GamesModel(
    val count: Int,
    val results: List<GameList>,
)

data class GameList(
    val id: Int,
    val name: String,
    val backgroundImage: String,
)
