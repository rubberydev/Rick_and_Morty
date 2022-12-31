package com.rubberydev.rick_and_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.rubberydev.rick_and_morty.databinding.ActivityMainBinding
import com.rubberydev.rick_and_morty.model.CharacterDbClient
import com.rubberydev.rick_and_morty.model.TheCharacterDbService
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val charactersAdapter = CharactersAdapter(emptyList()){ character ->
            Toast.makeText(this@MainActivity, "",Toast.LENGTH_SHORT).show()
        }

        binding.recycler.adapter = charactersAdapter
        lifecycleScope.launch {
            val charactersFromApi = CharacterDbClient.service.getCharacters()
            charactersAdapter.characters = charactersFromApi.results
            charactersAdapter.notifyDataSetChanged()

        }
    }
}