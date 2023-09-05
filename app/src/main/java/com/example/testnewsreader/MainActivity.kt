package com.example.testnewsreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testnewsreader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val titleFragment = TitleFragment()
        fragmentTransaction.replace(R.id.frameLayout_main, titleFragment).addToBackStack(null).commit()

    }
}