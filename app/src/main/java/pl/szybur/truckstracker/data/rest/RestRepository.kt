package pl.szybur.truckstracker.data.rest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pl.szybur.truckstracker.data.api.VehicleDetails
import pl.szybur.truckstracker.data.api.VehiclesRepository
import pl.szybur.truckstracker.data.api.toVehicleDetails

class RestRepository: VehiclesRepository {

    private val service = createTrucksApiService()

    override fun getVehicles(): Flow<Result<List<VehicleDetails>>> = flow {
        while(true) {
            fetchAndEmitVehicleDetails()
            delay(FETCH_DELAY)
        }
    }.flowOn(Dispatchers.IO)

    private suspend fun FlowCollector<Result<List<VehicleDetails>>>.fetchAndEmitVehicleDetails() {
        val vehiclesResponse = service.listVehicles().execute()
        if (vehiclesResponse.isSuccessful) {
            val vehiclesList = vehiclesResponse.body() ?: listOf()
           val vehicleDetailsList = vehiclesList.map { vehicle ->
                val detailsResponse = service.getVehicleDetails(vehicle.vehicleId).execute()
                if (detailsResponse.isSuccessful) {
                    detailsResponse.body() ?: vehicle.toVehicleDetails()
                } else {
                    vehicle.toVehicleDetails()
                }
            }
            emit(Result.success(vehicleDetailsList))
        } else {
            emit(Result.failure(Exception(vehiclesResponse.errorBody()?.string() ?: "")))
        }
    }
}

private const val FETCH_DELAY = 5000L