package com.jasmeet.myapplication_1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jasmeet.myapplication_1.R
import com.jasmeet.myapplication_1.databinding.ItemGroceryBinding
import com.jasmeet.myapplication_1.model.Record

class TopGroceryAdapter(private var context: Context, private val list: List<Record>):RecyclerView.Adapter<TopGroceryAdapter.TopGrocerViewHolder>() {

    inner class TopGrocerViewHolder(view: View):RecyclerView.ViewHolder(view){
        var binding = ItemGroceryBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopGrocerViewHolder {
        return TopGrocerViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_grocery,parent,false))
    }

    override fun onBindViewHolder(holder: TopGrocerViewHolder, position: Int) {
        val item = list[position]

        holder.binding.tvCommodity.text = item.commodity
        holder.binding.tvPrice.text = item.modal_price.toString()
        holder.binding.tvVillages.text = item.market
        holder.binding.tvDistricts.text = item.district
        holder.binding.tvDate.text = item.arrival_date

    }

    override fun getItemCount(): Int {
        return list.size
    }
}