package pl.szybur.truckstracker.data.api

data class Vehicle(val vehicleId: String)

data class VehicleDetails(val vehicleId: String, val location: Location = Location())

fun Vehicle.toVehicleDetails() = VehicleDetails(vehicleId)
