package com.example.myestate.ui.screens.home
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myestate.R
import com.example.myestate.room.Favorite
import com.example.myestate.room.FavoriteRoomService
import com.example.myestate.ui.screens.home.models.AdvertOnHome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface HomeViewModelInterface {
    var state : StateFlow<HomeContract.UiState>
    val estateTypeUi: StateFlow<HomeContract.EstateTypeUiState>
    val categoryUi : StateFlow<HomeContract.CategoryUiState>
    val advertOnHomeUi : StateFlow<HomeContract.AdvertOnHomeUiState>
    fun onAction(action:HomeContract.UiAction)
    fun onClickFavIcon(id:Int)
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val service: HomeServiceInterface,
    private val favoriteRoomService: FavoriteRoomService
) : ViewModel(),HomeViewModelInterface {
    private val _uiState = MutableStateFlow(HomeContract.UiState())
    override var state : StateFlow<HomeContract.UiState> = _uiState

    private val _estateTypeUi = MutableStateFlow(HomeContract.EstateTypeUiState())
   override val estateTypeUi: StateFlow<HomeContract.EstateTypeUiState> = _estateTypeUi

    private val _categoryUi = MutableStateFlow(HomeContract.CategoryUiState())
   override val categoryUi : StateFlow<HomeContract.CategoryUiState> = _categoryUi

    private val _advertOnHomeUi = MutableStateFlow(HomeContract.AdvertOnHomeUiState())
    override val advertOnHomeUi : StateFlow<HomeContract.AdvertOnHomeUiState> = _advertOnHomeUi
    private var tempAdvertList : List<AdvertOnHome> = emptyList()

    private var selectedEstateType:String = "All"
    private var selectedCategory:String = "All"



    init {
        fetchData()
    }

    private fun fetchData(){
        // estate type
        viewModelScope.launch {
            service.fetchAllEstateType()
            val data = service.getAllEstateType()
            _estateTypeUi.value.title = R.string.estateType

            if (data.second){
                _estateTypeUi.value = _estateTypeUi.value.copy(
                    list = emptyList(),
                    error =  Pair(R.string.errorMessage,true)
                )
            }else{

                _estateTypeUi.value = _estateTypeUi.value.copy(
                    list = data.first.map { estateType ->
                        estateType.copy(
                            textColor = if(estateType.id == 1) 0xFFFFFFFF else 0xFF52607D,
                            backColor = if (estateType.id == 1) 0xFF0000FF else 0xFFFFFFFF
                        )
                    },
                    error = Pair(R.string.empty,false)
                )
            }
        }

        // category
        viewModelScope.launch {
            service.fetchAllCategory()
            val data = service.getAllCategory()
            _categoryUi.value.title = R.string.categories
            if (data.second){
                _categoryUi.value = _categoryUi.value.copy(
                    title = R.string.adverts,
                    list = emptyList(),
                    error = Pair(R.string.errorMessage,true)
                )
            }else{
                _categoryUi.value = _categoryUi.value.copy(
                    list = data.first.map { category ->
                        category.copy(textColor = if(category.id == 1) 0xFFFFFFFF else 0xFF52607D,
                            backColor = if (category.id == 1) 0xFF0000FF else 0xFFFFFFFF)
                    },
                    error = Pair(R.string.empty,false)
                )
            }
        }

        fetchAdvert()


    }

    private fun fetchAdvert() {
        // adverts
        viewModelScope.launch {
            service.fetchAllAdvertsOnHome()
            val data = service.getAllAdvertsOnHome()
            _advertOnHomeUi.value.title = R.string.adverts
            if(data.second){
                _advertOnHomeUi.value = _advertOnHomeUi.value.copy(
                    list = emptyList(),
                )
                _uiState.value = _uiState.value.copy(
                    error = Pair(R.string.errorMessage,true)
                )
                tempAdvertList = emptyList()

            }else{
                tempAdvertList = data.first
                _advertOnHomeUi.value = _advertOnHomeUi.value.copy(
                    list = data.first.map {  advertOnHome ->
                        val control = favoriteRoomService.favControl(advertOnHome.id)
                        advertOnHome.copy(
                            onFavState = control > 0
                        )
                    },
                    message = Pair(R.string.empty,false)
                )
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

        selectedEstateType = updateList.filter { it.id == id }[0].type

        filterAdvert()

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
        selectedCategory = updateList.filter { it.id == id }[0].name

        filterAdvert()
    }

    private fun filterAdvert(){
     val filterList = tempAdvertList.filter { advertOnHome ->
          val estateTypes = selectedEstateType.lowercase() == "all" || selectedEstateType.lowercase() == advertOnHome.estateType.lowercase()
          val categories = selectedCategory.lowercase() == "all"  || selectedCategory.lowercase() == advertOnHome.category.lowercase()
          estateTypes && categories
      }

        if (filterList.isEmpty()){
            _advertOnHomeUi.value = _advertOnHomeUi.value.copy(
                list = emptyList(),
                message = Pair(R.string.noData,true)
            )
        }else{
            _advertOnHomeUi.value = _advertOnHomeUi.value.copy(
                list = filterList,
                message = Pair(R.string.empty,false)
            )
        }
    }

    override fun onClickFavIcon(id: Int) {
        val advert = _advertOnHomeUi.value.list.first { it.id == id }
        val favorite = Favorite(
            advert.id,
            advert.images[0],
            advert.title,
            advert.city,
            advert.district,
            advert.price.toInt())
        viewModelScope.launch {
            val control = favoriteRoomService.favControl(id)
            if (control > 0){
                favoriteRoomService.deleteFav(id )
            }else{
                favoriteRoomService.addFav(favorite)
            }
        }

        fetchAdvert()
    }
}