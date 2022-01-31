package com.aeab13.training.web_service

import kotlinx.coroutines.delay
import com.aeab13.training.fruits

class FruitsWebService {
    suspend fun getFruits(): List<String> {
        delay(2000)
        return fruits
    }
}