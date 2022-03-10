package com.sample.myapplication.ui.main.tasks.task1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sample.domain.interactor.GetAllCharacterUseCase
import com.sample.domain.model.Character
import com.sample.domain.model.Characters
import com.sample.domain.model.Result
import com.sample.myapplication.ui.main.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Task1ViewModel @Inject constructor(
    private val getAllCharacterUseCase: GetAllCharacterUseCase
) : BaseViewModel() {

    private val _characters: MutableLiveData<List<Character>> by lazy {
        MutableLiveData<List<Character>>()
    }

    val characters: LiveData<List<Character>> get() = _characters

    fun loadData() {
        showLoader()
        viewModelScope.launch {
            val result = getAllCharacterUseCase.execute(GetAllCharacterUseCase.Params(1))
            hideLoader()
            when (result) {
                is Result.Success<Characters> -> {
                    val allCharacters = result.data
                    if (allCharacters.count > 0) {
                        _characters.postValue(allCharacters.people)
                    }
                }
                is Result.Error -> {
                    result.exception.message?.let { showToast(it) }
                }
            }
        }
    }

}