package com.aeab13.training.repositories

import com.aeab13.training.db.FruitsDb
import com.aeab13.training.web_service.FruitsWebService
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class FruitsRepositoryTest {
    lateinit var fruitsRepository: FruitsRepository

    @MockK
    lateinit var fruitsDb: FruitsDb
    @MockK
    lateinit var fruitsWebService: FruitsWebService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        fruitsRepository = FruitsRepository(fruitsWebService, fruitsDb)
    }

    @Test
    fun getFruits() = runBlocking {
        // setup would be executed

        val listOfFruitsExpected = listOf("Apple", "Orange", "Banana")
        val listOfFruitsCaptured = slot<List<String>>()

        coEvery { fruitsWebService.getFruits() } returns listOfFruitsExpected

        coEvery {
            fruitsDb.storeFruits(
                fruits = capture(listOfFruitsCaptured)
            )
        } answers {
            // The "answers" block is called whenever the method "storeFruits" is called
            val capturedFruitsList = listOfFruitsCaptured.captured

            Assert.assertEquals(listOfFruitsExpected.count(), capturedFruitsList.count())
        }

        val fruits = fruitsRepository.getFruits()

        coVerifyOrder {
            fruitsWebService.getFruits()
            fruitsDb.storeFruits(any())
        }

        Assert.assertEquals(listOfFruitsExpected.count(), fruits.count())
    }
}