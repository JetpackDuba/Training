package se.tutus.di_example

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Car @Inject constructor(
    private val engine: Engine,
    private val wheels: Wheels,
) {
    fun getTheEngineName(): String {
        return engine.whoIAm()
    }
}

abstract class Engine {
    abstract fun whoIAm(): String
}

class ElectricEngine @Inject constructor(): Engine() {
    override fun whoIAm(): String {
        return "An electric engine"
    }
}

class GasEngine @Inject constructor(): Engine() {
    override fun whoIAm(): String {
        return "A gas engine"
    }
}


class Wheels @Inject constructor()