package com.rubberydev.rick_and_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rubberydev.rick_and_morty.databinding.ActivityMainBinding
import com.rubberydev.rick_and_morty.model.Character


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val charactersAdapter = CharactersAdapter(emptyList()){ character ->
            Toast.makeText(this@MainActivity, "",Toast.LENGTH_SHORT).show()
        }*/

        binding.recycler.adapter = CharactersAdapter(
            listOf(
                Character("character 1", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
                Character("character 2", "https://rickandmortyapi.com/api/character/avatar/2.jpeg"),
                Character("character 3", "https://rickandmortyapi.com/api/character/avatar/3.jpeg"),
                Character("character 4", "https://rickandmortyapi.com/api/character/avatar/4.jpeg"),
                Character("character 5", "https://rickandmortyapi.com/api/character/avatar/5.jpeg"),
                Character("character 6", "https://rickandmortyapi.com/api/character/avatar/6.jpeg")
            )

        ) { character ->
        Toast.makeText(this@MainActivity, character.title, Toast.LENGTH_SHORT).show()
        }
        //binding.recycler.adapter = charactersAdapter
    }
}