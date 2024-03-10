package pl.szybur.truckstracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pl.szybur.truckstracker.data.api.VehiclesRepository
import pl.szybur.truckstracker.data.rest.RestRepository


@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    private val restRepository  = RestRepository()

    @Provides
    fun provideVehiclesRepository() : VehiclesRepository = restRepository
}

