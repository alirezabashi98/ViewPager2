package com.alirezabashi98.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private val dataValue: List<String>, private val condition: ConditionViewPager) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //val txt: TextView = view.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder =
        ViewPagerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        )

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        condition.condition(position,dataValue.size)
    }

    override fun getItemCount(): Int = dataValue.size

    interface ConditionViewPager {

        fun condition(position : Int, fullSize : Int)

    }

}