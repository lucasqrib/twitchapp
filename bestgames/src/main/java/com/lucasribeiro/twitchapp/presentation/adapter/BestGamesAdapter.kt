package com.lucasribeiro.twitchapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucasribeiro.twitchapp.R
import com.lucasribeiro.twitchapp.domain.model.Game
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.game_list_item.view.*

class BestGamesAdapter : PagedListAdapter<Game, BestGamesAdapter.VH>(
    GameDiffUtil
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.game_list_item, parent, false)

        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class VH(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(game: Game) {
            view.apply {
                textGameName.text = game.name
                Picasso.get().load(game.image).into(imageGame)
            }
        }

    }
}