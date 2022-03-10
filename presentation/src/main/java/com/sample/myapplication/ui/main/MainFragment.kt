package com.sample.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sample.myapplication.R
import com.sample.myapplication.databinding.MainFragmentBinding
import com.sample.myapplication.ui.main.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding, MainViewModel>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override val layoutId: Int
        get() = R.layout.main_fragment

    override fun setupViewBinding(view: View): MainFragmentBinding =
        MainFragmentBinding.bind(view)

    override fun setupViewModel(): MainViewModel {
        val viewModel: MainViewModel by viewModels()
        return viewModel
    }

    override fun onViewCreated(inflater: LayoutInflater, view: View, savedInstanceState: Bundle?) {
        viewBinding.tasksButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToMainTaskFragment())
        }

        viewBinding.extraButton.setOnClickListener {
//            viewModel.buttonClicked()
        }
    }
}