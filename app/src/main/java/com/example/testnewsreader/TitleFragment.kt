package com.example.testnewsreader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testnewsreader.databinding.ActivityMainBinding
import com.example.testnewsreader.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentTitleBinding.inflate(layoutInflater)

        val dataList = mutableListOf<News>()
        dataList.add(News("title1", "content1"))
        dataList.add(News("title2", "content2"))

        val adapter = NewsTitleAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }
}