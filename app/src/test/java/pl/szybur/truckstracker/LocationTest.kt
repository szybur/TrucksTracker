package pl.szybur.truckstracker

import org.junit.Test

import org.junit.Assert.*
import pl.szybur.truckstracker.data.api.LONDON
import pl.szybur.truckstracker.data.api.JARACZA_THEATRE
import pl.szybur.truckstracker.data.api.NEW_YORK
import pl.szybur.truckstracker.data.api.OLYMPIC_MUSEUM
import pl.szybur.truckstracker.data.api.PIOTRKOWSKA
import pl.szybur.truckstracker.data.api.TARGET_LOCATION
import pl.szybur.truckstracker.data.api.distance
import pl.szybur.truckstracker.data.api.isNearTarget

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LocationTest {
    @Test
    fun location_distance() {
        val distance = NEW_YORK.distance(LONDON)
        assertEquals("", 5570.0, distance, 0.5)

        assertTrue(OLYMPIC_MUSEUM.isNearTarget)
    }
}