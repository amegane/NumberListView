package com.example.numberlistview.ui.recyclerView

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.numberlistview.R
import com.example.numberlistview.data.ExampleData
import com.example.numberlistview.databinding.RecyclerviewCardBinding

class CardRecyclerViewAdapter(
    list: List<ExampleData>,
    private val context: Context,
) :
    RecyclerView.Adapter<CardRecyclerViewAdapter.CardRecyclerViewHolder>() {
    private lateinit var binding: RecyclerviewCardBinding
    private var seriesList: List<ExampleData> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardRecyclerViewHolder {
        binding =
            RecyclerviewCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardRecyclerViewHolder, position: Int) {
        val data = seriesList[position]
        Log.d("item", data.name)
        holder.imageBook.setImageResource(R.mipmap.ic_launcher_round)
        holder.textSeriesTitle.text = data.name

        val adapter = NumberListRecyclerViewAdapter(data.numberList, this.context)
        holder.volumeNumber.adapter = adapter
        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        holder.volumeNumber.layoutManager = manager
        holder.volumeNumber.setHasFixedSize(true)
    }

    fun update(list: List<ExampleData>) {
        seriesList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = seriesList.size

    class CardRecyclerViewHolder(binding: RecyclerviewCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        internal val imageBook: ImageView = binding.bookImage
        internal val textSeriesTitle: TextView = binding.seriesTitle
        internal val volumeNumber: RecyclerView = binding.recyclerView
    }
}