package com.example.study.viewpager

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        tabLayout2.addTab(tabLayout2.newTab().setText("Fragment1"))
        tabLayout2.addTab(tabLayout2.newTab().setText("Fragment2"))
        tabLayout2.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position)
            }

        })
        viewPager.addOnPageChangeListener(object:TabLayout.TabLayoutOnPageChangeListener(tabLayout2) {
        })
    }

    class ViewPagerAdapter(fm: android.support.v4.app.FragmentManager):FragmentStatePagerAdapter(fm)
    {
        var fragments = arrayOf(Fragment1(), Fragment2())

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
    }
}
