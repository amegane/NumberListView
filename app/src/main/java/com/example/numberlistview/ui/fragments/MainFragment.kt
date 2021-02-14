package com.example.numberlistview.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numberlistview.R
import com.example.numberlistview.data.ExampleData
import com.example.numberlistview.databinding.MainFragmentBinding
import com.example.numberlistview.ui.recyclerView.CardRecyclerViewAdapter
import com.example.numberlistview.viewmodels.MainViewModel

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: CardRecyclerViewAdapter
    private var currentDataList = mutableListOf<ExampleData>()
    private var dataSize = currentDataList.size + 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        binding.apply {
            this.viewModel = viewModel
            lifecycleOwner = viewLifecycleOwner

            recyclerView.run {
                layoutManager = LinearLayoutManager(context)
                adapter = CardRecyclerViewAdapter(
                    currentDataList,
                    requireContext()
                ).also {
                    this@MainFragment.adapter = it
                }
                setHasFixedSize(true)
            }

            buttonAdd.setOnClickListener {
                val list = mutableListOf<Int>()
                var count = 1
                while (count <= dataSize) {
                    list.add(count)
                    count++
                }
                val data = ExampleData(dataId = null, name = "test$dataSize", numberList = list)
                viewModel.insert(data)
            }

            buttonDelete.setOnClickListener {
                currentDataList.forEach {
                    viewModel.delete(it)
                }
            }
        }

        viewModel.exampleDataList.observe(viewLifecycleOwner, { list ->
            adapter.update(list)
            currentDataList = list.toMutableList()
            dataSize = currentDataList.size + 1
            Log.d("list", list.toString())
        })
        return binding.root
    }
}