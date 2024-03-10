package pl.szybur.truckstracker.ui.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import pl.szybur.truckstracker.data.api.VehicleDetails
import pl.szybur.truckstracker.data.api.VehiclesRepository
import javax.inject.Inject

@HiltViewModel
class TrucksViewModel @Inject constructor(
    private val repository: VehiclesRepository
) : ViewModel() {

    val trucks: Flow<Result<List<VehicleDetails>>>
        get() = repository.getVehicles()
}