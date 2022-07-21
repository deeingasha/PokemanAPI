package com.example.pokemanapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemanapi.databinding.ItemBerryBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class BerryAdapter : ListAdapter<Berry, BerryAdapter.VH>(BerryDiffUtil) {


    class VH(val itemBerryBinding: ItemBerryBinding) : RecyclerView.ViewHolder(itemBerryBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemBerryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }



    override fun onBindViewHolder(holder: VH, position: Int) {
        val berry = getItem(position)

        holder.itemBerryBinding.apply {
            tvName.text = berry.name
            tvUrl.text = berry.url
        }

    }
}

private val BerryDiffUtil = object : DiffUtil.ItemCallback<Berry>() {
    override fun areItemsTheSame(oldItem: Berry, newItem: Berry): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Berry, newItem: Berry): Boolean {
        return oldItem == newItem
    }
}