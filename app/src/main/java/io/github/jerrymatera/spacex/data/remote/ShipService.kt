package io.github.jerrymatera.spacex.data.remote

import io.github.jerrymatera.spacex.data.models.SpaceShip
import retrofit2.http.GET
import retrofit2.http.Path

interface ShipService {

    @GET("/ships")
    suspend fun getShips(): List<SpaceShip>

    @GET("/ships/{id}")
    suspend fun getShipById(
        @Path("id") id: String
    ): SpaceShip
}