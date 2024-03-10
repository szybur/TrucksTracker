package pl.szybur.truckstracker.data.api

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

data class Location(val latitude: Double = Double.POSITIVE_INFINITY, val longitude: Double = Double.POSITIVE_INFINITY)

fun Location.distance(location: Location): Double {
    val earthRadius = 6371.0
    val dLat = Math.toRadians(location.latitude - latitude)
    val dLon = Math.toRadians(location.longitude - longitude)
    val originLat = Math.toRadians(latitude)
    val destinationLat = Math.toRadians(location.latitude)

    // Haversine formula
    val a = sin(dLat / 2).pow(2) +
            sin(dLon / 2).pow(2) *
            cos(originLat) *
            cos(destinationLat)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    return earthRadius * c
}

val TARGET_LOCATION = Location(latitude= 46.5223916, longitude= 6.6314437)

val LONDON = Location(latitude = 51.5074, longitude = -0.1278)
val NEW_YORK = Location(latitude = 40.7128, longitude = -74.0060)
val PIOTRKOWSKA = Location(latitude = 51.7594, longitude = 19.4572)
val JARACZA_THEATRE = Location(latitude = 51.7605, longitude = 19.4663)
val OLYMPIC_MUSEUM = Location(latitude = 46.5167, longitude = 6.6332)

val Location.isNearTarget
    get() = distance(TARGET_LOCATION) < 1.0