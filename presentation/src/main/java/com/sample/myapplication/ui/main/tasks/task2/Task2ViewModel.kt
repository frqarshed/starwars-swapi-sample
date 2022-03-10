package com.sample.myapplication.ui.main.tasks.task2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sample.domain.interactor.GetAllPlanetsUseCase
import com.sample.domain.model.*
import com.sample.myapplication.ui.main.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Task2ViewModel @Inject constructor(
    private val getAllPlanetsUseCase: GetAllPlanetsUseCase
) : BaseViewModel() {

    private val _planets: MutableLiveData<List<Planet>> by lazy {
        MutableLiveData<List<Planet>>()
    }

    val planets: LiveData<List<Planet>> get() = _planets

    fun loadData() {
        showLoader()
        viewModelScope.launch {
            val result = getAllPlanetsUseCase.execute(GetAllPlanetsUseCase.Params(1))
            hideLoader()
            when (result) {
                is Result.Success<Planets> -> {
                    val allPlanets = result.data
                    if (allPlanets.count > 0) {
                        _planets.postValue(allPlanets.planets)
                    }
                }
                is Result.Error -> {
                    result.exception.message?.let { showToast(it) }
                }
            }
        }
    }
}