package io.github.jerrymatera.spacex.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.data.remote.RemoteDataSource
import io.github.jerrymatera.spacex.utils.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val remoteDataSource: RemoteDataSource): ViewModel() {
    private val _spaceShips = MutableLiveData<Resource<List<SpaceShip>>>()
    val spaceShips: LiveData<Resource<List<SpaceShip>>>
        get() {
           return _spaceShips
        }

    init {
        getSpaceShips()
    }
    private fun getSpaceShips(){
        viewModelScope.launch{
            _spaceShips.value = remoteDataSource.getSpaceShips()
        }
    }
}