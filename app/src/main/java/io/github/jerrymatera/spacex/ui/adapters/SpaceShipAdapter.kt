package io.github.jerrymatera.spacex.ui.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.databinding.SpaceShipItemBinding
import io.github.jerrymatera.spacex.ui.adapters.SpaceShipAdapter.*
import javax.inject.Inject

class SpaceShipAdapter @Inject constructor() :
    ListAdapter<SpaceShip, SpaceShipViewHolder>(SpaceShipsDiffUtilCallback()) {
    class SpaceShipViewHolder(private val binding: SpaceShipItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(spaceShip: SpaceShip) {
            with(binding) {
                shipName.text = spaceShip.ship_name
                shipHomeDepot.text = spaceShip.home_port
                shipImg.load(data = spaceShip.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceShipViewHolder {
        return SpaceShipViewHolder(
            SpaceShipItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SpaceShipViewHolder, position: Int) {
        val spaceShip = getItem(position)
        if (spaceShip != null) {
            holder.bind(spaceShip)
        }
    }
}

class SpaceShipsDiffUtilCallback : DiffUtil.ItemCallback<SpaceShip>() {
    override fun areItemsTheSame(oldItem: SpaceShip, newItem: SpaceShip): Boolean {
        return oldItem.ship_id == newItem.ship_id
    }

    override fun areContentsTheSame(oldItem: SpaceShip, newItem: SpaceShip): Boolean {
        return oldItem == newItem
    }

}
