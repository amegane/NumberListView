package com.example.numberlistview.ui.recyclerView

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.numberlistview.R
import com.example.numberlistview.databinding.RecyclerviewNumberlistBinding
import com.example.numberlistview.ui.customView.CircularTextView

class NumberListRecyclerViewAdapter(list: List<Int>, private val context: Context) :
    RecyclerView.Adapter<NumberListRecyclerViewAdapter.NumberRecyclerViewHolder>() {
    private lateinit var binding: RecyclerviewNumberlistBinding
    private val volumeList: MutableList<Int> = list.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberRecyclerViewHolder {
        binding = RecyclerviewNumberlistBinding.inflate(LayoutInflater.from(context), parent, false)
        return NumberRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberRecyclerViewHolder, position: Int) {
        holder.indexTextView.text = volumeList[position].toString()
        if (volumeList.contains(volumeList[position])) {
            holder.indexTextView.background = getDrawable(context, R.drawable.ic_purple_700)
            holder.indexTextView.setTextColor(Color.WHITE)
        } else {
            holder.indexTextView.background = getDrawable(context, R.drawable.ic_white)
            holder.indexTextView.setTextColor(Color.parseColor("#FF3700B3"))
        }
    }

    override fun getItemCount(): Int = volumeList.size

    class NumberRecyclerViewHolder(binding: RecyclerviewNumberlistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        internal val indexTextView: CircularTextView = binding.indexText
    }
}