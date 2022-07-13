package io.github.jerrymatera.spacex.data.models

data class SpaceShipDetail(
    val abs: Any,
    val active: Boolean,
    val attempted_landings: Any,
    val `class`: Any,
    val course_deg: Any,
    val home_port: String,
    val image: String,
    val imo: Any,
    val missions: List<Mission>,
    val mmsi: Int,
    val position: Position,
    val roles: List<String>,
    val ship_id: String,
    val ship_model: Any,
    val ship_name: String,
    val ship_type: String,
    val speed_kn: Int,
    val status: String,
    val successful_landings: Any,
    val url: String,
    val weight_kg: Any,
    val weight_lbs: Any,
    val year_built: Any
)