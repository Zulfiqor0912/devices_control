package uz.gita.devicecontrol.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.gita.devicecontrol.data.common.model.Data
import uz.gita.devicecontrol.databinding.ItemInfoBinding

class DevicesAdapter : PagingDataAdapter<Data, DevicesAdapter.ViewHolder>(diffCallback) {
    private lateinit var binding: ItemInfoBinding
    private lateinit var context: Context
    private var onItemClickListener: ((Data) -> Unit)? = null

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Data, newItem: Data) =
                oldItem == newItem

        }
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data) {
            binding.apply {
                textDeviceName.text = item.name
                textUserName.text = item.account_number
                textData.text = item.created_at
            }
        }
    }

    override fun onBindViewHolder(holder: DevicesAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevicesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemInfoBinding.inflate(inflater, parent, false)
        return ViewHolder()
    }

    fun onItemClickListener(listener: (Data) -> Unit) {
        onItemClickListener = listener
    }


}