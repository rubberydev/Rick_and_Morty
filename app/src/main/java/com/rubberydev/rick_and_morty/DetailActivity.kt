package com.rubberydev.rick_and_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
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
        val into = Glide
            .with(this)
            .load(character?.image)
            .into(binding.backdrop)

        paintMoreInfoDetail(binding.detailInfo, character)
    }

     private fun paintMoreInfoDetail(detailInfo: TextView,character: Character?) {

        detailInfo.text = buildSpannedString {
                 bold { append("Status: ") }
                 appendLine(character?.status)

                 bold { append("Specie: ") }
                 appendLine(character?.species)

                 bold { append("Gender: ") }
                 appendLine(character?.gender)

                 bold { append("Origin name: ") }
                 appendLine(character?.origin?.name)

                 bold { append("Location name: ") }
                 appendLine(character?.location?.name)

                 bold { append("Created: ") }
                 appendLine(character?.created)

                bold { append("Status: ") }
                appendLine(character?.status)

                bold { append("Specie: ") }
                appendLine(character?.species)

                bold { append("Gender: ") }
                appendLine(character?.gender)

                bold { append("Origin name: ") }
                appendLine(character?.origin?.name)

                bold { append("Location name: ") }
                appendLine(character?.location?.name)

                bold { append("Created: ") }
                appendLine(character?.created)

                bold { append("Status: ") }
                appendLine(character?.status)

                bold { append("Specie: ") }
                appendLine(character?.species)

                bold { append("Gender: ") }
                appendLine(character?.gender)

                bold { append("Origin name: ") }
                appendLine(character?.origin?.name)

                bold { append("Location name: ") }
                appendLine(character?.location?.name)

                bold { append("Created: ") }
                appendLine(character?.created)
        }
    }


}