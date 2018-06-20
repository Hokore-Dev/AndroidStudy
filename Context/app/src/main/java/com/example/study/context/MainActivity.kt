package com.example.study.context

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.framelayout_main, MyFragment()).commit()

        //Toast.makeText(this,  "토스트 메시지 입니다.", Toast.LENGTH_LONG).show()
    }
}
