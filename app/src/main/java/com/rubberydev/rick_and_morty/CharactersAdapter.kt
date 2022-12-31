package com.rubberydev.rick_and_morty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rubberydev.rick_and_morty.databinding.ViewCharacterItemBinding
import com.rubberydev.rick_and_morty.model.Character

class CharactersAdapter(val characters : List<Character>) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = ViewCharacterItemBinding.inflate(LayoutInflater
                .from(parent.context),
            parent, false)


            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(characters[position])
        }

        override fun getItemCount() = characters.size

     class ViewHolder(private val binding: ViewCharacterItemBinding): RecyclerView.ViewHolder(binding.root){
         fun bind(character: Character){
            binding.title.text = character.title
         }
     }

    }