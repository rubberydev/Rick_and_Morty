package com.rubberydev.rick_and_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rubberydev.rick_and_morty.databinding.ActivityMainBinding
import com.rubberydev.rick_and_morty.model.Character


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = CharactersAdapter(
            listOf(
                Character("character 1", "url 1"),
                Character("character 2", "url 2"),
                Character("character 3", "url 3"),
                Character("character 4", "url 4"),
                Character("character 5", "url 5"),
                Character("character 6", "url 6")
            )

        )
    }
}