package com.husseinmohammed.applyroom.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.husseinmohammed.applyroom.data.local.CharactersLocalPojo
import com.husseinmohammed.applyroom.databinding.ItemCharBinding

// Created by Your name on 9/28/2021.
@SuppressLint("NotifyDataSetChanged")
class CharAdapter(var context: Context) :
    RecyclerView.Adapter<CharAdapter.CharVM>() {

    private var chars: ArrayList<CharactersLocalPojo> = arrayListOf()

    fun addData(chars: List<CharactersLocalPojo>) {
        this.chars.addAll(chars)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharVM {
        context = parent.context
        return CharVM(ItemCharBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: CharVM, position: Int) = holder.bind(chars[position])

    override fun getItemCount(): Int = chars.size

    inner class CharVM(private val binding: ItemCharBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(char: CharactersLocalPojo) {
            binding.tvCharacterName.text = char.charName
            Glide.with(context)
                .load(char.charImage)
                .into(binding.ivCharacter)
        }
    }
}