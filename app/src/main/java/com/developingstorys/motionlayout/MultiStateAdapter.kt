package com.developingstorys.motionlayout

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MultiStateAdapter(private val size: Int) : RecyclerView.Adapter<MultiStateViewHolder>() {

    override fun getItemCount(): Int = size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiStateViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_multi_state, parent, false)
        val color = if (size > 3)
            android.R.color.white
        else
            R.color.colorPrimary
        (itemView.rootView as? ConstraintLayout)?.setBackgroundColor(parent.context.getColor(color))
        return MultiStateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MultiStateViewHolder, position: Int) {
        holder.apply {
            shoppingStoreName.text = "Store Store Store $position"
            shoppingStoreAddress.text = "Store Address Store Address Store Address $position"
            val color = if (size > 3) {
                shoppingStoreName.setTextColor(itemView.context.resources.getColor(android.R.color.black))
                shoppingStoreAddress.setTextColor(itemView.context.resources.getColor(android.R.color.black))
                android.R.color.black
            } else {
                shoppingStoreName.setTextColor(itemView.context.resources.getColor(android.R.color.holo_red_light))
                shoppingStoreAddress.setTextColor(itemView.context.resources.getColor(android.R.color.holo_red_light))
                android.R.color.holo_red_light
            }
        }
    }
}

class MultiStateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val shoppingStoreName: TextView by lazy { itemView.findViewById<TextView>(R.id.store_tv) }
    val shoppingStoreAddress: TextView by lazy { itemView.findViewById<TextView>(R.id.store_address_tv) }

    init {
        itemView.setOnClickListener {
            Log.d("LOG_TAG---", "${shoppingStoreName.text}")
        }
    }
}