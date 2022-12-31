package com.rubberydev.rick_and_morty.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterDbClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        val service = retrofit.create(TheCharacterDbService::class.java)

}