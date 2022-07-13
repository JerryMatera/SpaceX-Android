package io.github.jerrymatera.spacex.data.remote

import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.utils.Resource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val spaceSpaceShipService: SpaceShipService) {
    suspend fun getSpaceShipById(id: String): Resource<SpaceShip> {
        return spaceSpaceShipService.getSpaceShipById(id)
    }

    suspend fun  getSpaceShips() : Resource<List<SpaceShip>>{
        return spaceSpaceShipService.getSpaceShips()
    }
}