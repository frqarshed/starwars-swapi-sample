package com.sample.myapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sample.domain.interactor.GetAllMoviesUseCase
import com.sample.domain.model.Movies
import com.sample.domain.model.Result
import com.sample.myapplication.ui.main.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) : BaseViewModel() {

    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun buttonClicked() {
        showLoader()
        viewModelScope.launch {
            val result = getAllMoviesUseCase.execute(GetAllMoviesUseCase.Params(1))
            hideLoader()
            when (result) {
                is Result.Success<Movies> -> {
                    message.postValue(
                        "Hello From Button " + result.data.count
                    )
                }
                else -> {
                    message.postValue("The API Failed")
                }
            }
        }
    }
}