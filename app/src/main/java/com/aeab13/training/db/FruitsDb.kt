package com.aeab13.training.db

import kotlinx.coroutines.delay

class FruitsDb {
    suspend fun storeFruits(fruits: List<String>) {
        delay(1000)
    }
}