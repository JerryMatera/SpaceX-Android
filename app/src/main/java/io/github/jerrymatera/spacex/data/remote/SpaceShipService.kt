package io.github.jerrymatera.spacex.data.remote

import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceShipService {

    @GET("/ships")
    suspend fun getSpaceShips(): Resource<List<SpaceShip>>

    @GET("/ships/{id}")
    suspend fun getSpaceShipById(
        @Path("id") id: String
    ): Resource<SpaceShip>
}