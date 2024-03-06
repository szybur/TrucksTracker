package pl.szybur.truckstracker.data.rest

import pl.szybur.truckstracker.data.api.Vehicle
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

import pl.szybur.truckstracker.BuildConfig
import pl.szybur.truckstracker.data.api.VehicleDetails
import retrofit2.http.Headers
import retrofit2.http.Path


interface TrucksApiService {
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("vehicles")
    fun listVehicles(): Call<List<Vehicle>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("vehicles/{vehicleId}")
    fun getVehicleDetails(@Path("vehicleId") vehicleId: String): Call<VehicleDetails>
}

fun createTrucksApiService(): TrucksApiService = Retrofit.Builder()
    .baseUrl(BuildConfig.API_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(TrucksApiService::class.java)