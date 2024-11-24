package com.example.myestate.ui.screens.home
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myestate.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface HomeViewModelInterface {
    var state : StateFlow<HomeContract.UiState>
    val estateTypeUi: StateFlow<HomeContract.EstateTypeUiState>
    val categoryUi : StateFlow<HomeContract.CategoryUiState>
    fun onAction(action:HomeContract.UiAction)
}

@HiltViewModel
class HomeViewModel @Inject constructor(private val service: HomeServiceInterface) : ViewModel(),HomeViewModelInterface {
    private val _uiState = MutableStateFlow(HomeContract.UiState())
    override var state : StateFlow<HomeContract.UiState> = _uiState

    private val _estateTypeUi = MutableStateFlow(HomeContract.EstateTypeUiState())
   override val estateTypeUi: StateFlow<HomeContract.EstateTypeUiState> = _estateTypeUi

    private val _categoryUi = MutableStateFlow(HomeContract.CategoryUiState())
   override val categoryUi : StateFlow<HomeContract.CategoryUiState> = _categoryUi


    init {
        writeUiState()
        fetchData()
    }

    private fun writeUiState(){



    }

    private fun fetchData(){
        // estate type
        viewModelScope.launch {
            service.fetchAllEstateType()
            val data = service.getAllEstateType()
            _estateTypeUi.value.title = R.string.estateType

            if (data.second){
                _estateTypeUi.value.list = emptyList()
               _estateTypeUi.value.error = _estateTypeUi.value.error.copy(R.string.errorMessage,true)
            }else{
                _estateTypeUi.value.list = data.first.map { estateType ->
                    estateType.copy(
                        textColor = if(estateType.id == 1) 0xFFFFFFFF else 0xFF52607D,
                        backColor = if (estateType.id == 1) 0xFF0000FF else 0xFFFFFFFF
                    )
                }
                _estateTypeUi.value.error = _estateTypeUi.value.error.copy(R.string.empty,false)
            }
        }

        // category
        viewModelScope.launch {
            service.fetchAllCategory()
            val data = service.getAllCategory()
            _categoryUi.value.title = R.string.categories
            if (data.second){
                _categoryUi.value.list = emptyList()
                _categoryUi.value.error = _categoryUi.value.error.copy(R.string.errorMessage,true)
            }else{
                _categoryUi.value.list = data.first.map { category ->
                    category.copy(
                        textColor = if(category.id == 1) 0xFFFFFFFF else 0xFF52607D,
                        backColor = if (category.id == 1) 0xFF0000FF else 0xFFFFFFFF
                    )
                }
                _categoryUi.value.error = _categoryUi.value.error.copy(R.string.empty,false)
            }

        }
    }

    override fun onAction(action:HomeContract.UiAction) {
        when(action){
            is HomeContract.UiAction.clickedEstateType -> onClickEstateType(action.id)
            is HomeContract.UiAction.clickedCategory -> onClickCategory(action.id)
        }
    }

    private fun onClickEstateType(id: Int){
        val updateList = _estateTypeUi.value.list.map { estateType ->
            estateType.copy(
                textColor = if(estateType.id == id) 0xFFFFFFFF else 0xFF52607D,
                backColor = if (estateType.id == id) 0xFF0000FF else 0xFFFFFFFF
            )
        }

        _estateTypeUi.value = _estateTypeUi.value.copy(
            list = updateList
        )
    }

    private fun onClickCategory(id:Int){
        val updateList = _categoryUi.value.list.map { category ->
            category.copy(
                textColor = if(category.id == id) 0xFFFFFFFF else 0xFF52607D,
                backColor = if (category.id == id) 0xFF0000FF else 0xFFFFFFFF
            )
        }

        _categoryUi.value = _categoryUi.value.copy(
            list = updateList
        )
    }
}