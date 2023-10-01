package uz.gita.devicecontrol.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.gita.devicecontrol.data.common.model.DeviceData
import uz.gita.devicecontrol.databinding.ItemInfoBinding

class DevicesAdapter : PagingDataAdapter<DeviceData, DevicesAdapter.ViewHolder>(diffCallback) {
    private lateinit var binding: ItemInfoBinding
    private lateinit var context: Context
    private var onItemClickListener: ((DeviceData) -> Unit)? = null

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<DeviceData>() {
            override fun areItemsTheSame(oldItem: DeviceData, newItem: DeviceData) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: DeviceData, newItem: DeviceData) =
                oldItem == newItem

        }
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DeviceData) {
            binding.apply {
                textDeviceName.text = item.name
                textUserName.text = item.account_number
                textData.text = item.created_at
            }
        }
    }

    override fun onBindViewHolder(holder: DevicesAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        holder.setIsRecyclable(false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevicesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemInfoBinding.inflate(inflater, parent, false)
        return ViewHolder()
    }

    fun onItemClickListener(listener: (DeviceData) -> Unit) {
        onItemClickListener = listener
    }


}