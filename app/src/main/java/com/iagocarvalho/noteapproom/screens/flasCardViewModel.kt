package com.iagocarvalho.noteapproom.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagocarvalho.noteapproom.data.flasCardDataSource
import com.iagocarvalho.noteapproom.model.FlasCard
import com.iagocarvalho.noteapproom.repository.FlasCardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class flasCardViewModel @Inject constructor(private val flasCardRepository: FlasCardRepository) :
    ViewModel() {

    private val _flasCardList = MutableStateFlow<List<FlasCard>>(emptyList())
    val flasCardList = _flasCardList.asStateFlow()
    //var flasCardList = mutableStateListOf<FlasCard>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            flasCardRepository.getAllFlasCards().distinctUntilChanged().collect { ListOfFlasCard ->
                if (ListOfFlasCard.isNullOrEmpty()) {
                    Log.d("Empty", ": Empty list")
                } else {
                    _flasCardList.value = ListOfFlasCard
                }
            }
        }
        //flasCardList.addAll(flasCardDataSource().loadflasCards())
    }

    fun addFlasCard(flasCard: FlasCard) =
        viewModelScope.launch { flasCardRepository.addFlasCards(flasCard) }

    fun removeflasCard(flasCard: FlasCard) =
        viewModelScope.launch { flasCardRepository.deleteFlasCards(flasCard) }

    fun updateFlascard(flasCard: FlasCard) =
        viewModelScope.launch { flasCardRepository.updateFlasCards(flasCard) }


//    fun getAllNotes(): List<FlasCard>{
//        return flasCardList
//    }
}