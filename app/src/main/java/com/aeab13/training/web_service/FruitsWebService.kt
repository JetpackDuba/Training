package com.aeab13.training.web_service

import kotlinx.coroutines.delay
import com.aeab13.training.fruits
import javax.inject.Inject

class FruitsWebService @Inject constructor() {
    suspend fun getFruits(): List<String> {
        delay(2000)
        return fruits
    }
}