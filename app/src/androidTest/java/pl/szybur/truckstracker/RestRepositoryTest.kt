package pl.szybur.truckstracker

import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import pl.szybur.truckstracker.data.rest.RestRepository

@RunWith(AndroidJUnit4::class)
class RestRepositoryTest {

    @Test
    fun fetchVehicles() = runBlocking {
        val repository = RestRepository()

        repository.getVehicles().collect { result ->
            //assert(result.isSuccess)
            //assert(result.getOrNull()?.first()?.vehicleId == "dupa")
            println("RECEIVED VEHICLES")
            if (result.isFailure) {
                println(result.exceptionOrNull()?.message)
            } else {
                result.getOrDefault(listOf()).forEach{
                    println(it)
                }
            }
        }

    }
}