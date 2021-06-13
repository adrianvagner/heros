package com.heroes.ui.heroes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.heroes.domain.dto.HeroDto
import com.heroes.R
import com.heroes.databinding.ItemHeroTileBinding

class HeroesAdapter : RecyclerView.Adapter<HeroesAdapter.BookViewHolder>() {

    var heroes: List<HeroDto> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hero_tile, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount() = heroes.size

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemHeroTileBinding.bind(itemView)

        fun bind(hero: HeroDto) {
            binding.tvName.text = hero.name
            binding.tvPower.text = hero.powerStats.power
            binding.tvIntelligence.text = hero.powerStats.intelligence
            binding.tvSpeed.text = hero.powerStats.speed
            val context = binding.root.context


            Glide.with(itemView.context)
                .load(hero.image.url)
                .into(binding.ivCover)
        }

    }

}