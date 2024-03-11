package pl.szybur.truckstracker.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import pl.szybur.truckstracker.data.api.VehicleDetails
import pl.szybur.truckstracker.data.api.VehiclesRepository
import pl.szybur.truckstracker.ui.ID_PARAM
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel@Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: VehiclesRepository
): ViewModel() {

    val selectedId: String  = savedStateHandle.get<String>(ID_PARAM)!!

    val trucks: Flow<Result<List<VehicleDetails>>>
        get() = repository.getVehicles()
}