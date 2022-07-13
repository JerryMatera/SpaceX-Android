package io.github.jerrymatera.spacex.data.repository

import io.github.jerrymatera.spacex.data.remote.RemoteDataSource
import io.github.jerrymatera.spacex.domain.repository.SpaceShipRepository

class SpaceShipRepositoryImpl constructor(remoteDataSource: RemoteDataSource): SpaceShipRepository {
    override suspend fun getSpaceShips() {
        TODO("Not yet implemented")
    }

    override suspend fun getSpaceshipById(id: String) {
        TODO("Not yet implemented")
    }
}