package com.example.study.recyclerviewlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = MainRecyclerViewAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
    {
        var images = arrayOf(R.drawable.cupcake, R.drawable.coffee, R.drawable.coffee1, R.drawable.dessert)
        var titles = arrayOf("test1", "test2", "test3", "test4")
        var subs = arrayOf("sub1", "sub2", "sub3", "sub4")

        override fun getItemCount(): Int {
            return 4
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var view = holder as CustomViewHolder
            view.imageview!!.setImageResource(images[position])
            view.textview!!.text = titles[position]
            view.textview2!!.text = subs[position]
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_layout, parent, false)
            return CustomViewHolder(view)
        }

        class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
            var imageview: ImageView? = null
            var textview: TextView? = null
            var textview2: TextView? = null

            init {
                imageview = view!!.findViewById(R.id.imageView2)
                textview = view!!.findViewById(R.id.textView4)
                textview2 = view!!.findViewById(R.id.textSub)
            }
        }

    }
}
