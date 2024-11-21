package com.example.assignment.ViewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.DataClasses.Data
import com.example.assignment.apiService
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    data class RecipeState(
        var loading:Boolean = true,
        var data: Data? = null,
        val error:String? = null,
    )

    private val _fetchRecipe = mutableStateOf(RecipeState())
    val fetchRecipe:State<RecipeState> = _fetchRecipe

    fun fetchDataFromApi(){
        viewModelScope.launch {
           try {
               val service = apiService.getData()
               _fetchRecipe.value = _fetchRecipe.value.copy(
                   loading = false,
                   data = service,
                   error = null
               )
           }catch (e:Exception){
               _fetchRecipe.value = _fetchRecipe.value.copy(
                   loading = false,
                   error = e.message
               )
           }
        }
    }

}