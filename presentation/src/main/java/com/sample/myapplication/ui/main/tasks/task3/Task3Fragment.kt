package com.sample.myapplication.ui.main.tasks.task3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.data.core.extension.gone
import com.sample.data.core.extension.visible
import com.sample.myapplication.R
import com.sample.myapplication.databinding.Task3FragmentBinding
import com.sample.myapplication.ui.main.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Task3Fragment : BaseFragment<Task3FragmentBinding, Task3ViewModel>() {

    companion object {
        fun newInstance() = Task3Fragment()
    }

    override val layoutId: Int
        get() = R.layout.task_3_fragment

    override fun setupViewBinding(view: View): Task3FragmentBinding =
        Task3FragmentBinding.bind(view)

    override fun setupViewModel(): Task3ViewModel {
        val task3ViewModel: Task3ViewModel by viewModels()
        return task3ViewModel
    }

    override fun onViewCreated(inflater: LayoutInflater, view: View, savedInstanceState: Bundle?) {
        val adapter = MoviesAdapter(viewModel, emptyList())
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