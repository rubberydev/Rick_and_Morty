package com.rubberydev.rick_and_morty.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.rubberydev.rick_and_morty.databinding.ActivityMainBinding
import com.rubberydev.rick_and_morty.model.CharacterDbClient
import kotlinx.coroutines.launch
import com.rubberydev.rick_and_morty.model.Character
import com.rubberydev.rick_and_morty.ui.detail.DetailActivity
import com.rubberydev.rick_and_morty.utilities.Network.Companion.isConnected


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val charactersAdapter = CharactersAdapter(emptyList()){ navigateTo(it) }
        binding.recycler.adapter = charactersAdapter

        if(!isConnected(this)){
            Toast.makeText(this@MainActivity,"you must enable your internet settings", Toast.LENGTH_SHORT).show()
            return
        }
        
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