package com.lucasribeiro.twitchapp.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.lucasribeiro.twitchapp.domain.model.Game

object GameDiffUtil : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem == newItem
    }

}