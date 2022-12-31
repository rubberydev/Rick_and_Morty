package com.rubberydev.rick_and_morty.model

import retrofit2.Call
import retrofit2.http.GET

interface TheCharacterDbService {
    @GET("/api/character")
    suspend fun getCharacters(): CharacterDbResult
}