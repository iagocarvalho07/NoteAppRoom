package com.iagocarvalho.noteapproom.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.iagocarvalho.noteapproom.data.flasCardDataSource
import com.iagocarvalho.noteapproom.model.FlasCard

class flasCardViewModel : ViewModel() {
    var flasCardList = mutableStateListOf<FlasCard>()

    init {
        flasCardList.addAll(flasCardDataSource().loadflasCards())
    }

    fun addFlasCard(flasCard: FlasCard) {
        flasCardList.add(flasCard)
    }

    fun removeflasCard(flasCard: FlasCard) {
        flasCardList.remove(flasCard)
    }

    fun getAllNotes(): List<FlasCard>{
        return flasCardList
    }
}