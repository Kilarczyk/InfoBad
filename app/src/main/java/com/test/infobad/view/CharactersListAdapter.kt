package com.test.infobad.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.infobad.R
import com.test.infobad.databinding.CharacterItemBinding
import com.test.infobad.model.CharacterModel

class CharactersListAdapter(characterList: List<CharacterModel>, private val onClickListener: OnCustomClickListener) : RecyclerView.Adapter<CharactersListAdapter.CharacterViewHolder>() {

    private var charList = characterList

    interface OnCustomClickListener{
        fun clickListener(character: CharacterModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(layoutInflater.inflate(R.layout.character_item, parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = charList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClickListener.clickListener(item)
        }
    }

    override fun getItemCount(): Int = charList.size

    class CharacterViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val binding = CharacterItemBinding.bind(view)

        fun bind(character : CharacterModel){
            Glide.with(binding.root).load(character.img).into(binding.charImage)
            binding.charActor.text = character.portrayed
            binding.charNickname.text = character.nickname
        }
    }

    fun setCharacterList(characterList: List<CharacterModel>) {
        charList = characterList
        notifyDataSetChanged()
    }

}