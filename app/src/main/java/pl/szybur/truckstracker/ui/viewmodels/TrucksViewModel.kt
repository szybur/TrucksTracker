package pl.szybur.truckstracker.ui.viewmodels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import pl.szybur.truckstracker.data.api.LONDON
import pl.szybur.truckstracker.data.api.OLYMPIC_MUSEUM
import pl.szybur.truckstracker.data.api.PIOTRKOWSKA
import pl.szybur.truckstracker.data.api.VehicleDetails
import javax.inject.Inject

@HiltViewModel
class TrucksViewModel @Inject constructor()
    :ViewModel() {
    val trucks: Flow<Result<List<VehicleDetails>>>
        get() = flowOf(Result.success(items))

    private val items = listOf(
        VehicleDetails(vehicleId = "iojhn-87629", location = PIOTRKOWSKA),
        VehicleDetails(vehicleId = "lnbtw-90876", location = OLYMPIC_MUSEUM),
        VehicleDetails(vehicleId = "qacde-09517", location = LONDON)
    )
}