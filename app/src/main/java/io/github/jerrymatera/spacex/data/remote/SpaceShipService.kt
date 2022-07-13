package io.github.jerrymatera.spacex.data.remote

import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.utils.BASE_URL
import io.github.jerrymatera.spacex.utils.Resource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceShipService {

    @GET("/ships")
    suspend fun getSpaceShips(): Resource<List<SpaceShip>>

    @GET("/ships/{id}")
    suspend fun getSpaceShipById(
        @Path("id") id: String
    ): Resource<SpaceShip>

    companion object {
        fun create(): SpaceShipService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SpaceShipService::class.java)

        }
    }
}