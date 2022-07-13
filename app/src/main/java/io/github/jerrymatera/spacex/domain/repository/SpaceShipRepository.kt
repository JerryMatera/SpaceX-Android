package io.github.jerrymatera.spacex.domain.repository

interface SpaceShipRepository {
    suspend fun getSpaceShips()
    suspend fun getSpaceshipById(id: String)
}