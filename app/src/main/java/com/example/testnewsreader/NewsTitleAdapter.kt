package com.example.testnewsreader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.testnewsreader.databinding.NewsTitleBinding

class NewsTitleAdapter(val newsList: MutableList<News>) : RecyclerView.Adapter<NewsTitleAdapter.Holder>() {
    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = NewsTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            val news = newsList[position]
            val detailFragment = DetailFragment()
            holder.bind(news)
            holder.itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("articleDetail", news.content)
                detailFragment.arguments = bundle

                // Fragment 전환
                val fragmentManager = (it.context as AppCompatActivity).supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout_main, detailFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
        holder.title.text = newsList[position].title
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class Holder(val binding: NewsTitleBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.textTitle
        fun bind(news: News) {
//            binding.profileImageView.setImageResource(contact.image)
            binding.textTitle.text = news.title
        }

    }


}