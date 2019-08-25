package com.lucasribeiro.beststreamers.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.lucasribeiro.beststreamers.domain.model.Stream

object StreamDiffUtil : DiffUtil.ItemCallback<Stream>() {
    override fun areItemsTheSame(oldItem: Stream, newItem: Stream): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Stream, newItem: Stream): Boolean {
        return oldItem == newItem
    }

}