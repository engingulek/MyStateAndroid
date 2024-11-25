package com.example.myestate.ui.screens.detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myestate.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


interface AdvertDetailViewModelInterface{
    var state : State<AdvertDetailContract.UiState>
    var advertDetail : StateFlow<AdvertDetailContract.AdvertDetailState>
    fun getAdvertId(id:Int?)
}

@HiltViewModel
class AdvertDetailViewModel @Inject constructor(
    private val service: AdvertDetailServiceInterface)
    : ViewModel(),AdvertDetailViewModelInterface {

    private val _uiState = mutableStateOf(AdvertDetailContract.UiState())
    override var state : State<AdvertDetailContract.UiState> = _uiState

    private val _advertDetailState = MutableStateFlow(AdvertDetailContract.AdvertDetailState())
    override var advertDetail: StateFlow<AdvertDetailContract.AdvertDetailState> = _advertDetailState


    init {
        writeUiState()
    }

   override fun getAdvertId(id:Int?){
       id?.let {
           getAdvertDetail(id)
       }

    }


    private  fun writeUiState(){
        _uiState.value = AdvertDetailContract.UiState(
            R.string.advertInfo,
            R.string.description,
            R.string.price,
            R.string.advertId,
            R.string.estateType,
            R.string.advertDate,
            R.string.age,
            R.string.Floors
        )
    }

    private fun getAdvertDetail(id:Int) {
        viewModelScope.launch {
            service.fetchAdvertDetail(id)
            val data = service.getAdvertDetail()
            if(data.second){
                _advertDetailState.value = _advertDetailState.value.copy(
                    advertDetail = null,
                    error = Pair(R.string.errorMessage,true)
                )
            }else{
                data.first?.let {
                    _advertDetailState.value = _advertDetailState.value.copy(
                        advertDetail = it,
                        error = Pair(R.string.empty,false)
                    )
                }
            }
        }
    }
}