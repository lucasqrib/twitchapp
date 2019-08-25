package com.lucasribeiro.beststreamers.presentation

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
import com.lucasribeiro.beststreamers.R
import com.lucasribeiro.beststreamers.presentation.adapter.BestStreamersAdapter
import kotlinx.android.synthetic.main.best_streamers_list_fragment.*
import kotlinx.android.synthetic.main.best_streamers_list_fragment.view.*
import org.koin.android.ext.android.inject

class BestStreamersListFragment : Fragment() {

    private val viewModel: BestStreamersViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.best_streamers_list_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AppBarConfiguration(findNavController().graph).let {
            toolbar_layout?.setupWithNavController(toolbar, findNavController(), it)
        }
        bindRecyclerView(view)
    }

    private fun bindRecyclerView(view: View) {
        val adapter = BestStreamersAdapter()
        view.recyclerBestStreamers.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
        viewModel.streams.observe(this, Observer { adapter.submitList(it) })
    }

}