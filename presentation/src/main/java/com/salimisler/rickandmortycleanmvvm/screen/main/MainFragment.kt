package com.salimisler.rickandmortycleanmvvm.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.salimisler.rickandmortycleanmvvm.R
import com.salimisler.rickandmortycleanmvvm.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    val viewModel by viewModels<MainViewModel>()
    var binding: FragmentMainBinding? = null
    lateinit var navHostFragmentMainFragment: NavHostFragment
    lateinit var navControllerMainFragment: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        navHostFragmentMainFragment = childFragmentManager
            .findFragmentById(R.id.container_main_fragment) as NavHostFragment
        navControllerMainFragment = navHostFragmentMainFragment.navController

        val bottomNavigationView = binding?.bottomNavigationView
        bottomNavigationView?.setupWithNavController(navControllerMainFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}