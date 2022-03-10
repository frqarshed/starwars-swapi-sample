package com.sample.myapplication.ui.main.extra

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sample.domain.interactor.GetAllMoviesUseCase
import com.sample.domain.model.Movie
import com.sample.domain.model.Movies
import com.sample.domain.model.Result
import com.sample.myapplication.ui.main.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllMoviesViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) : BaseViewModel() {

    private val _movies: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>()
    }

    val movies: LiveData<List<Movie>> get() = _movies

    fun loadData() {
        showLoader()
        viewModelScope.launch {
            val result = getAllMoviesUseCase.execute(GetAllMoviesUseCase.Params(1))
            hideLoader()
            when (result) {
                is Result.Success<Movies> -> {
                    val allMovies = result.data
                    if (allMovies.count > 0) {
                        _movies.postValue(allMovies.movies)
                    }
                }
                is Result.Error -> {
                    result.exception.message?.let { showToast(it) }
                }
            }
        }
    }
}