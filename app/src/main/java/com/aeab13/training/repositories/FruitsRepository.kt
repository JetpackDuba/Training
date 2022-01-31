package com.aeab13.training.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import com.aeab13.training.fruits

class FruitsRepository {
    suspend fun getFruits() = withContext(Dispatchers.IO) {
        delay(2000)
        return@withContext fruits
    }
}