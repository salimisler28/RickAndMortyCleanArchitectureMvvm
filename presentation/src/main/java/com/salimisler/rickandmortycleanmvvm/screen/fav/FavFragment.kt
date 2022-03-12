package com.salimisler.rickandmortycleanmvvm.screen.fav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.salimisler.data.base.BaseException
import com.salimisler.rickandmortycleanmvvm.R
import com.salimisler.rickandmortycleanmvvm.base.BaseFragment
import com.salimisler.rickandmortycleanmvvm.databinding.FragmentFavBinding
import com.salimisler.rickandmortycleanmvvm.screen.fav.adapter.FavController
import com.salimisler.rickandmortycleanmvvm.util.extention.gone
import com.salimisler.rickandmortycleanmvvm.util.extention.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavFragment: BaseFragment<FragmentFavBinding, FavViewModel>(R.layout.fragment_fav) {
    override val viewModel: FavViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFavBinding
        get() = FragmentFavBinding::inflate
    val controller by lazy { FavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initFlows()
    }

    private fun initRecyclerView() = binding.rvFav.apply {
        adapter = controller.adapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initFlows() {
        lifecycleScope.launch {
            viewModel.dataSF.collectLatest {
                controller.data = it
                controller.requestModelBuild()
            }
        }
    }

    override fun showDialog() = binding.pbLoading.visible()
    override fun hideDialog() = binding.pbLoading.gone()
    override fun showError(baseException: BaseException) {

    }
}