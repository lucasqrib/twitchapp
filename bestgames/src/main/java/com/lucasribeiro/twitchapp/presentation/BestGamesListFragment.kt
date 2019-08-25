package com.lucasribeiro.twitchapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucasribeiro.twitchapp.R
import com.lucasribeiro.twitchapp.presentation.adapter.BestGamesAdapter
import kotlinx.android.synthetic.main.best_games_list_fragment.*
import kotlinx.android.synthetic.main.best_games_list_fragment.view.*
import org.koin.android.ext.android.inject

class BestGamesListFragment : Fragment() {

    private val viewModel: BestGamesViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.best_games_list_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AppBarConfiguration(findNavController().graph).let {
            toolbar_layout?.setupWithNavController(toolbar, findNavController(), it)
        }
        bindRecyclerView(view)
    }

    private fun bindRecyclerView(view: View) {
        val adapter = BestGamesAdapter()
        view.recyclerBestGames.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
        viewModel.games.observe(this, Observer { adapter.submitList(it) })
    }

}