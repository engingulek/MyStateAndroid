package com.example.myestate.ui.screens.home
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myestate.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface HomeViewModelInterface {
    var state : StateFlow<HomeContract.UiState>
    fun onAction(action:HomeContract.UiAction)
}

@HiltViewModel
class HomeViewModel @Inject constructor(private val service: HomeServiceInterface) : ViewModel(),HomeViewModelInterface {
    private val _uiState = MutableStateFlow(HomeContract.UiState())
    override var state : StateFlow<HomeContract.UiState> = _uiState

    private val _estateTypeUi = MutableStateFlow(HomeContract.EstateTypeUiState())
    val estateTypeUi: StateFlow<HomeContract.EstateTypeUiState> = _estateTypeUi

    init {
        writeUiState()
        fetchData()
    }

    private fun writeUiState(){
        _uiState.value.categoryTitle = R.string.categories
        _uiState.value.advertTitle = R.string.adverts

    }

    private fun fetchData(){
        viewModelScope.launch {
            service.fetchAllEstateType()
            val list = service.getAllEstateType()
            _estateTypeUi.value.title = R.string.estateType

            _estateTypeUi.value.list = list.map { estateType ->
                estateType.copy(
                    isSelected = estateType.id == 1,
                    textColor = if(estateType.id == 1) 0xFFFFFFFF else 0xFF52607D,
                    backColor = if (estateType.id == 1) 0xFF0000FF else 0xFFFFFFFF
                )
            }
        }
    }

    override fun onAction(action:HomeContract.UiAction) {
        when(action){
            is HomeContract.UiAction.clickedEstateType -> onClickEstateType(action.id)
        }
    }

    private fun onClickEstateType(id: Int){
        val updateList = _estateTypeUi.value.list.map { estateType ->
            estateType.copy(
                isSelected = estateType.id == id,
                textColor = if(estateType.id == id) 0xFFFFFFFF else 0xFF52607D,
                backColor = if (estateType.id == id) 0xFF0000FF else 0xFFFFFFFF
            )
        }

        _estateTypeUi.value = _estateTypeUi.value.copy(
            list = updateList
        )
    }
}