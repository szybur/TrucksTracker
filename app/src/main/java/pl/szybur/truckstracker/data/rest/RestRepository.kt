package pl.szybur.truckstracker.data.rest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pl.szybur.truckstracker.data.api.Vehicle
import pl.szybur.truckstracker.data.api.VehiclesRepository

class RestRepository: VehiclesRepository {

    private val service = createTrucksApiService()

    override fun getVehicles(): Flow<Result<List<Vehicle>>> = flow {
        val response = service.listVehicles().execute()
        if (response.isSuccessful) {
            emit(Result.success(response.body() ?: listOf()))
        } else {
            emit(Result.failure(Exception(response.errorBody()?.string() ?: "")))
        }
    }.flowOn(Dispatchers.IO)
}