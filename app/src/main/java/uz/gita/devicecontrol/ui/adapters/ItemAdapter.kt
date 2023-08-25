package uz.gita.devicecontrol.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.devicecontrol.data.model.DeviceData
import uz.gita.devicecontrol.databinding.ItemInfoBinding

class ItemAdapter : ListAdapter<DeviceData, ItemAdapter.Holder>(MyDiffUtil) {
    private var clickProductItem: ((data: DeviceData) -> Unit)? = null

    inner class Holder(private val binding: ItemInfoBinding) : ViewHolder(binding.root) {

        init {
            binding.item.setOnClickListener {
                clickProductItem?.invoke(getItem(adapterPosition))
            }
        }

        fun bind() {
            binding.apply {
                with(currentList[adapterPosition]) {
                    textDeviceName.text = name
                }
            }
        }


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
        return Holder(ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        return holder.bind()
    }

    fun clickItem(block: (data: DeviceData) -> Unit) {
        clickProductItem = block
    }
}