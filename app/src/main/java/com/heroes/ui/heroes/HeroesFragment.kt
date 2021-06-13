package com.heroes.ui.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.heroes.databinding.FragmentHeroesBinding
import com.heroes.domain.dto.HeroDto
import com.heroes.ui.heroes.adapter.HeroesAdapter
import com.heroes.utils.gone
import com.heroes.utils.visible

class HeroesFragment : Fragment() {

    private val binding: FragmentHeroesBinding by lazy {
        FragmentHeroesBinding.inflate(layoutInflater)
    }

    private val viewModel: HeroesViewModel by viewModels()

    private lateinit var adapter: HeroesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        loadArguments()
        setupView()
        setupListeners()
    }

    private fun loadArguments() {
    }

    private fun setupView() {
        adapter = HeroesAdapter()

        binding.rvHeroes.adapter = adapter
        binding.rvHeroes.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupListeners() {
        viewModel.heroesResult.observe(viewLifecycleOwner, ::onHeroesResult)
        viewModel.heroesError.observe(viewLifecycleOwner) { onHeroesError() }

        binding.rlHeroes.setOnRefreshListener { findHeroes() }

        findHeroes()
    }

    private fun findHeroes() {
        binding.errorView.gone()
        viewModel.getHeroes()
    }

    private fun onHeroesResult(heroes: List<HeroDto>) {
        adapter.heroes = heroes
        binding.rlHeroes.isRefreshing = false
        binding.rvHeroes.visible()
    }

    private fun onHeroesError() {
        binding.rlHeroes.isRefreshing = false
        binding.rvHeroes.gone()
        binding.errorView.visible()
    }

}