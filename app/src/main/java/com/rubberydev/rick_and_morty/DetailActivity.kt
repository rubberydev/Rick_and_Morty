package com.rubberydev.rick_and_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rubberydev.rick_and_morty.databinding.ActivityDetailBinding
import com.rubberydev.rick_and_morty.model.Character



class DetailActivity : AppCompatActivity() {

    companion object{

        const val EXTRA_CHARACTER ="DetailActivity:character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val character = intent.getParcelableExtra<Character>(EXTRA_CHARACTER)
        title = character?.name
        Glide
            .with(this)
            .load(character?.image)
            .into(binding.backdrop)
    }
}