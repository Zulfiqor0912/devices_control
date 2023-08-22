package uz.gita.devicecontrol.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.devicecontrol.data.model.DeviceData
import uz.gita.devicecontrol.databinding.ItemInfoBinding

class ItemAdapter : ListAdapter<DeviceData, ItemAdapter.Holder>(MyDiffUtil) {

    inner class Holder(private val binding: ItemInfoBinding) : ViewHolder(binding.root) {

    }

    object MyDiffUtil : DiffUtil.ItemCallback<DeviceData>() {
        override fun areItemsTheSame(oldItem: DeviceData, newItem: DeviceData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: DeviceData, newItem: DeviceData): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        TODO("Not yet implemented")
    }
}