package com.rubberydev.rick_and_morty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.rubberydev.rick_and_morty.databinding.ActivityMainBinding
import com.rubberydev.rick_and_morty.model.CharacterDbClient
import com.rubberydev.rick_and_morty.model.TheCharacterDbService
import kotlinx.coroutines.launch
import com.rubberydev.rick_and_morty.model.Character


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val charactersAdapter = CharactersAdapter(emptyList()){ navigateTo(it) }

        binding.recycler.adapter = charactersAdapter
        lifecycleScope.launch {
            val charactersFromApi = CharacterDbClient.service.getCharacters()
            charactersAdapter.characters = charactersFromApi.results
            charactersAdapter.notifyDataSetChanged()

        }
    }

    private fun navigateTo(it: Character) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_CHARACTER, it)
        startActivity(intent)

    }
}