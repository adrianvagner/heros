package com.heroes.ui.heroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heroes.data.remote.ApiResult
import com.heroes.domain.dto.HeroDto
import com.heroes.domain.repository.HeroRepository
import kotlinx.coroutines.launch

class HeroesViewModel : ViewModel() {

    private val heroesRepository = HeroRepository()

    val heroesResult: MutableLiveData<List<HeroDto>> = MutableLiveData()
    val heroesError: MutableLiveData<Unit> = MutableLiveData()

    fun getHeroes() {
        viewModelScope.launch {
            val result = heroesRepository.getList("a");
            when (result) {
                is ApiResult.Success -> heroesResult.postValue(result.data)
                else -> heroesError.postValue(Unit)
            }
        }
    }
}