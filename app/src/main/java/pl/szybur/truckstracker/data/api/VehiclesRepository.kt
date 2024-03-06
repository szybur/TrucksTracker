package pl.szybur.truckstracker.data.api

import kotlinx.coroutines.flow.Flow

interface VehiclesRepository {

    fun getVehicles(): Flow<Result<List<Vehicle>>>

}