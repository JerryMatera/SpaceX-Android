package io.github.jerrymatera.spacex.data.models

data class SpaceShip(
    val abs: Int,
    val active: Boolean,
    val image: String,
    val missions: List<Mission>,
    val position: Position,
    val roles: List<String>,
    val ship_id: String,
    val ship_model: String,
    val ship_name: String,
    val ship_type: String,
    val speed_kn: Double,
    val status: String,
    val url: String,
    val weight_kg: Int,
    val weight_lbs: Int,
    val year_built: Int
)