package com.rubberydev.rick_and_morty.model

data class CharacterDbResult(
    val info: Info,
    val results: List<Character>
)