package com.rubberydev.rick_and_morty.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.rubberydev.rick_and_morty.R
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
        val into = Glide
            .with(this)
            .load(character?.image)
            .into(binding.backdrop)

        paintMoreInfoDetail(binding.detailInfo, character)
    }

     private fun paintMoreInfoDetail(detailInfo: TextView,character: Character?) {

        detailInfo.text = buildSpannedString {
            appendInfo(R.string.status,character?.status )
            appendInfo(R.string.specie,character?.species)
            appendInfo(R.string.gender,character?.gender )
            appendInfo(R.string.origin_name,character?.origin?.name )
            appendInfo(R.string.location_name,character?.location?.name )
            appendInfo(R.string.created,character?.created)
        }
    }

   fun SpannableStringBuilder.appendInfo(resource: Int, value: String?){
       bold { append(getString(resource))
       }
       appendLine(": $value")
   }
}