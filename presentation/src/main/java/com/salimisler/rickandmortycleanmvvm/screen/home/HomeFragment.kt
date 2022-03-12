package com.salimisler.rickandmortycleanmvvm.screen.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.salimisler.data.base.BaseException
import com.salimisler.rickandmortycleanmvvm.R
import com.salimisler.rickandmortycleanmvvm.base.BaseFragment
import com.salimisler.rickandmortycleanmvvm.databinding.FragmentHomeBinding
import com.salimisler.rickandmortycleanmvvm.screen.home.adapter.HomeController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
    override val viewModel by viewModels<HomeViewModel>()
    val controller by lazy { HomeController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controller.fragment = this
        initRecyclerView()
        initListeners()
        initFlows()
    }

    private fun initListeners() {
        controller.onFavClickListener = {
            if (it?.isFav == false) viewModel.insertFav(it.id)
        }
    }

    private fun initFlows() {
        lifecycleScope.launch {
            viewModel.charactersSF.collect {
                it?.let { controller.submitData(it) }
            }
        }
    }

    private fun initRecyclerView() = binding.ervHome.apply {
        layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = controller.adapter
    }

    override fun showDialog() {

    }

    override fun hideDialog() {

    }

    override fun showError(baseException: BaseException) {

    }

}