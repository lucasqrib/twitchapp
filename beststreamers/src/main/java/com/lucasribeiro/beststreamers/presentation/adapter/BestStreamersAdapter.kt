package com.lucasribeiro.beststreamers.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.lucasribeiro.beststreamers.R
import com.lucasribeiro.beststreamers.domain.model.Stream
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.streamer_list_item.view.*

class BestStreamersAdapter : PagedListAdapter<Stream, BestStreamersAdapter.VH>(
    StreamDiffUtil
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.streamer_list_item, parent, false)

        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class VH(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(stream: Stream) {
            view.apply {
                textStreamTitle.text = stream.title
                textStreamUser.text = stream.user.name
                textStreamViewers.text =
                    context?.resources?.getQuantityString(
                        R.plurals.viewers,
                        stream.viewerCount,
                        stream.viewerCount
                    )
                Picasso.get().load(stream.image).into(imageStream)
            }
        }

    }
}