package se.tutus.di_example.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import se.tutus.di_example.ElectricEngine
import se.tutus.di_example.Engine
import se.tutus.di_example.GasEngine

@Module
@InstallIn(SingletonComponent::class)
class EngineModule {
    @Provides
    fun providesEngine(engine: ElectricEngine): Engine {
        return engine
    }
}