package com.example.study.context

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by sundaytoz on 2018-06-20.
 */
class MyFragment : Fragment()
{

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.myfragment, container, false)

        // 상위 액티비티를 찾아서 Context를 받아옴
        Toast.makeText(activity,  "토스트 메시지 입니다.", Toast.LENGTH_LONG).show()

        return view
    }
}