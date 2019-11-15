package com.escodro.puisto.features.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import kotlin.random.Random

class CityRepository {

    @FlowPreview
    suspend fun loadRandomCity(): Flow<String> =
        fetchCityId()
            .flatMapConcat { fetchCityById(it) }

    private suspend fun fetchCityId(): Flow<Int> =
        withContext(Dispatchers.IO) {
            delay(1000)
            flowOf(Random.nextInt(8))
        }

    private suspend fun fetchCityById(cityId: Int): Flow<String> =
        withContext(Dispatchers.IO) {
            delay(1000)
            flowOf(cityList[cityId])
        }

    private val cityList =
        listOf("San Francisco", "Paris", "São Paulo", "Montreal", "London", "La Paz")
}