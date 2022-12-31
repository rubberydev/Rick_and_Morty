package com.rubberydev.rick_and_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rubberydev.rick_and_morty.databinding.ActivityDetailBinding



class DetailActivity : AppCompatActivity() {

    companion object{

        const val EXTRA_TITLE ="DetailActivity:title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.text = intent.getStringExtra(EXTRA_TITLE)
    }
}