package uz.gita.devicecontrol.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.devicecontrol.databinding.LoadMoreBinding

class LoadAdapter(private val retry: () -> Unit) : LoadStateAdapter<LoadAdapter.ViewHolder>() {
    private lateinit var binding: LoadMoreBinding


    inner class ViewHolder(retry: () -> Unit) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnLoadMoreRetry.setOnClickListener { retry() }
        }

        fun setData(state: LoadState) {
            binding.apply {
                prgBarLoadMore.isVisible = state is LoadState.Loading
                tvLoadMore.isVisible = state is LoadState.Error
                btnLoadMoreRetry.isVisible = state is LoadState.Error
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        holder.setData(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        binding = LoadMoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(retry)
    }
}