package com.sample.myapplication.ui.main.tasks.task1

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.domain.model.Character
import com.sample.myapplication.databinding.ItemCharacterBinding

class CharactersAdapter(
    val viewModel: Task1ViewModel
) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private var characters = mutableListOf<Character>()

    fun addCharacters(character: List<Character>) {
        characters.clear()
        characters.addAll(character)
        notifyDataSetChanged()
    }

    fun addCharacter(character: Character) {
        characters.add(character)
        notifyItemInserted(characters.indexOf(character))
    }

    fun removeCharacter(character: Character) {
        notifyItemRemoved(characters.indexOf(character))
        characters.remove(character)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CharactersAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharactersAdapter.ViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.name.text = character.name
            binding.eyeColor.text = character.eyeColor
            val color = Character.EyeColor.fromString(character.eyeColor)
            binding.imgViewIcon.setColorFilter(color.hexValue, PorterDuff.Mode.SRC_IN);
        }
    }
}