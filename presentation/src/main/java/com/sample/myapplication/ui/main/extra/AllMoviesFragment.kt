package com.sample.myapplication.ui.main.extra

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.data.core.extension.gone
import com.sample.data.core.extension.visible
import com.sample.myapplication.R
import com.sample.myapplication.databinding.AllMoviesFragmentBinding
import com.sample.myapplication.ui.main.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllMoviesFragment : BaseFragment<AllMoviesFragmentBinding, AllMoviesViewModel>() {

    companion object {
        fun newInstance() = AllMoviesFragment()
    }

    override val layoutId: Int
        get() = R.layout.all_movies_fragment

    override fun setupViewBinding(view: View): AllMoviesFragmentBinding =
        AllMoviesFragmentBinding.bind(view)

    override fun setupViewModel(): AllMoviesViewModel {
        val taskViewModel: AllMoviesViewModel by viewModels()
        return taskViewModel
    }

    override fun onViewCreated(inflater: LayoutInflater, view: View, savedInstanceState: Bundle?) {
        val adapter = AllMoviesAdapter(viewModel, emptyList())
        viewBinding.list.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.list.adapter = adapter

        var isDataLoaded = false
        viewModel.movies.observe(viewLifecycleOwner) {
            isDataLoaded = true
            adapter.addMovies(it)
        }

        viewModel.connectivityLiveData.observe(viewLifecycleOwner) {
            if (!it && !isDataLoaded) {
                viewBinding.list.gone()
                viewBinding.noInternet.main.visible()
            } else {
                if (!isDataLoaded) {
                    viewModel.loadData()
                }
                viewBinding.list.visible()
                viewBinding.noInternet.main.gone()
            }
        }
    }
}