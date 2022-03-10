package com.sample.myapplication.ui.main.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sample.myapplication.R
import com.sample.myapplication.databinding.MainTaskFragmentBinding
import com.sample.myapplication.ui.main.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainTaskFragment : BaseFragment<MainTaskFragmentBinding, MainTaskViewModel>() {

    companion object {
        fun newInstance() = MainTaskFragment()
    }

    override val layoutId: Int
        get() = R.layout.main_task_fragment

    override fun setupViewBinding(view: View): MainTaskFragmentBinding =
        MainTaskFragmentBinding.bind(view)

    override fun setupViewModel(): MainTaskViewModel {
        val taskViewModel: MainTaskViewModel by viewModels()
        return taskViewModel
    }

    override fun onViewCreated(inflater: LayoutInflater, view: View, savedInstanceState: Bundle?) {
        viewBinding.task1.setOnClickListener {
            findNavController().navigate(MainTaskFragmentDirections.actionMainTaskFragmentToTask1Fragment())
        }

        viewBinding.task2.setOnClickListener {
            findNavController().navigate(MainTaskFragmentDirections.actionMainTaskFragmentToTask2Fragment())
        }

        viewBinding.task3.setOnClickListener {
            findNavController().navigate(MainTaskFragmentDirections.actionMainTaskFragmentToTask3Fragment())
        }
    }
}