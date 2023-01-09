package com.rubberydev.rick_and_morty.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.rubberydev.rick_and_morty.model.Character

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rubberydev.rick_and_morty.databinding.ViewCharacterItemBinding

class CharactersAdapter(var characters : List<com.rubberydev.rick_and_morty.model.Character>,
                         private val characterClickedListener: (Character) -> Unit
                       ) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = ViewCharacterItemBinding.inflate(LayoutInflater
                .from(parent.context),
            parent, false)


            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val character = characters[position]
            holder.bind(character)
            holder.itemView.setOnClickListener { characterClickedListener(character) }
        }

        override fun getItemCount() = characters.size

     class ViewHolder(private val binding: ViewCharacterItemBinding): RecyclerView.ViewHolder(binding.root){
         fun bind(character: Character){
            binding.title.text = character.name
             Glide
                 .with(binding.root.context)
                 .load(character.image)
                 .into(binding.cover)
         }
     }

    }