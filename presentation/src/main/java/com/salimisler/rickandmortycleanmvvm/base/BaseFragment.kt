package com.salimisler.rickandmortycleanmvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.salimisler.data.base.BaseException
import kotlinx.coroutines.flow.collectLatest

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(@LayoutRes layoutRes: Int) :
    Fragment(layoutRes) {
    abstract val viewModel: VM
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    private var _binding: VB? = null
    protected val binding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            viewModel.baseLoadingSF.collectLatest {
                when(it) {
                    true -> showDialog()
                    else -> hideDialog()
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.baseErrorSF.collectLatest {
                it?.let { showError(it) }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun showDialog()
    abstract fun hideDialog()
    abstract fun showError(baseException: BaseException)
}