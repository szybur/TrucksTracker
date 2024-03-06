package pl.szybur.truckstracker.data.rest

import pl.szybur.truckstracker.data.api.Vehicle
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

import pl.szybur.truckstracker.BuildConfig
import retrofit2.http.Headers


interface TrucksApiService {
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("vehicles")
    fun listVehicles(): Call<List<Vehicle>>
}

fun createTrucksApiService(): TrucksApiService = Retrofit.Builder()
    .baseUrl(BuildConfig.API_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(TrucksApiService::class.java)