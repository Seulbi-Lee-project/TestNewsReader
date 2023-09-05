package com.example.testnewsreader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testnewsreader.databinding.ActivityMainBinding
import com.example.testnewsreader.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val binding by lazy { FragmentDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val articleDetail = it.getString("articleDetail")
            binding.content.text = articleDetail
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
}