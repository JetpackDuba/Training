package com.aeab13.training.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.aeab13.training.db.FruitsDb
import com.aeab13.training.web_service.FruitsWebService

class FruitsRepository {
    private val fruitsWebService = FruitsWebService()
    private val fruitsDb = FruitsDb()

    suspend fun getFruits(): List<String> = withContext(Dispatchers.IO) {
        val fruits = fruitsWebService.getFruits()
        fruitsDb.storeFruits(fruits)

        return@withContext fruits
    }
}