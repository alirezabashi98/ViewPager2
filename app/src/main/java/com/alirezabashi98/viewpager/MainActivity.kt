package com.alirezabashi98.viewpager

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity(), ViewPagerAdapter.ConditionViewPager {

    private val data = mutableListOf<String>()
    private lateinit var viewPager: ViewPager2
    private lateinit var indicator: CircleIndicator3
    private lateinit var btnNext: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castView()
        addToList()

        viewPager.adapter = ViewPagerAdapter(data, this)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        indicator.setViewPager(viewPager)

        btnNext.setOnClickListener {
            viewPager.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
        }

        btnBack.setOnClickListener {
            viewPager.apply {
                beginFakeDrag()
                fakeDragBy(10f)
                endFakeDrag()
            }
        }

    }

    private fun castView() {

        viewPager = findViewById(R.id.view_pager2)
        indicator = findViewById(R.id.indicator)
        btnNext = findViewById(R.id.btn_next)
        btnBack = findViewById(R.id.btn_back)

    }

    private fun addToList() {
        for (item in 1..20) {
            data.add("item $item")
        }
    }

    override fun condition(position: Int, fullSize: Int) {

        if (position == fullSize) {
            btnNext.text = "پایان"
        }
        Toast.makeText(this, "$position / $fullSize", Toast.LENGTH_SHORT).show()

    }


}