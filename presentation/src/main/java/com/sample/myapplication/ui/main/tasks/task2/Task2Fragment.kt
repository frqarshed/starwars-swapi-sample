package com.sample.myapplication.ui.main.tasks.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.data.core.extension.gone
import com.sample.data.core.extension.visible
import com.sample.myapplication.R
import com.sample.myapplication.databinding.Task2FragmentBinding
import com.sample.myapplication.ui.main.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Task2Fragment : BaseFragment<Task2FragmentBinding, Task2ViewModel>() {

    companion object {
        fun newInstance() = Task2Fragment()
    }

    override val layoutId: Int
        get() = R.layout.task_2_fragment

    override fun setupViewBinding(view: View): Task2FragmentBinding =
        Task2FragmentBinding.bind(view)

    override fun setupViewModel(): Task2ViewModel {
        val task2ViewModel: Task2ViewModel by viewModels()
        return task2ViewModel
    }

    override fun onViewCreated(inflater: LayoutInflater, view: View, savedInstanceState: Bundle?) {
        val adapter = PlanetsAdapter(viewModel, emptyList())
        viewBinding.list.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.list.adapter = adapter

        var isDataLoaded = false
        viewModel.planets.observe(viewLifecycleOwner) {
            isDataLoaded = true
            adapter.addPlanets(it)
        }

        viewModel.connectivityLiveData.observe(viewLifecycleOwner) {
            if (!it && !isDataLoaded) {
                viewBinding.list.gone()
                viewBinding.noInternetLayout.main.visible()
            } else {
                if (!isDataLoaded) {
                    viewModel.loadData()
                }
                viewBinding.list.visible()
                viewBinding.noInternetLayout.main.gone()
            }
        }

    }
}