package com.sample.myapplication.ui.main.tasks.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.data.core.extension.gone
import com.sample.data.core.extension.visible
import com.sample.myapplication.R
import com.sample.myapplication.databinding.Task1FragmentBinding
import com.sample.myapplication.ui.main.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Task1Fragment : BaseFragment<Task1FragmentBinding, Task1ViewModel>() {

    companion object {
        fun newInstance() = Task1Fragment()
    }

    override val layoutId: Int
        get() = R.layout.task_1_fragment

    override fun setupViewBinding(view: View): Task1FragmentBinding =
        Task1FragmentBinding.bind(view)

    override fun setupViewModel(): Task1ViewModel {
        val task1ViewModel: Task1ViewModel by viewModels()
        return task1ViewModel
    }

    override fun onViewCreated(inflater: LayoutInflater, view: View, savedInstanceState: Bundle?) {
        val adapter = CharactersAdapter(viewModel)
        viewBinding.list.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.list.adapter = adapter

        var isDataLoaded = false
        viewModel.characters.observe(viewLifecycleOwner) {
            isDataLoaded = true
            adapter.addCharacters(
                if (it.count() > 5) {
                    it.subList(0, 5)
                } else {
                    it
                }
            )
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