package uz.gita.devicecontrol.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.devicecontrol.data.common.model.DeviceData
import uz.gita.devicecontrol.data.common.model.TestData
import uz.gita.devicecontrol.databinding.ItemInfoBinding

class ItemAdapter : ListAdapter<TestData, ItemAdapter.Holder>(MyDiffUtil) {
    private var clickProductItem: ((data: TestData) -> Unit)? = null

    inner class Holder(private val binding: ItemInfoBinding) : ViewHolder(binding.root) {

        init {
            binding.item.setOnClickListener {
                clickProductItem?.invoke(getItem(adapterPosition))
            }
        }

        fun bind() {
            binding.apply {
                with(currentList[adapterPosition]) {
                    textDeviceName.text = message
                }
            }
        }


    }

    object MyDiffUtil : DiffUtil.ItemCallback<TestData>() {
        override fun areItemsTheSame(oldItem: TestData, newItem: TestData): Boolean {
            return oldItem.message == newItem.message
        }

        override fun areContentsTheSame(oldItem: TestData, newItem: TestData): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        return holder.bind()
    }

    fun clickItem(block: (data: TestData) -> Unit) {
        clickProductItem = block
    }
}