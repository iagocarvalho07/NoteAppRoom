package com.iagocarvalho.noteapproom.repository

import com.iagocarvalho.noteapproom.data.FlasCardDataBaseDao
import com.iagocarvalho.noteapproom.model.FlasCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FlasCardRepository @Inject constructor(private val flasCardDataBaseDao: FlasCardDataBaseDao) {
    suspend fun addFlasCards(flasCard: FlasCard) = flasCardDataBaseDao.insert(flasCard)
    suspend fun updateFlasCards(flasCard: FlasCard) = flasCardDataBaseDao.update(flasCard)
    suspend fun deleteFlasCards(flasCard: FlasCard) = flasCardDataBaseDao.delete(flasCard)
    fun getAllFlasCards() : Flow<List<FlasCard>> = flasCardDataBaseDao.getAllItems()
        .flowOn(Dispatchers.IO).conflate()

}