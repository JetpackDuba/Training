package com.aeab13.training.db

import kotlinx.coroutines.delay
import javax.inject.Inject

class FruitsDb @Inject constructor() {
    suspend fun storeFruits(fruits: List<String>) {
        delay(1000)
    }
}