package com.example.study.activitylifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart(){
        println("1단계 : 액티비티가 생성될 때 호출된다")
    }

    override fun onResume()
    {
        println("2단계 : 액티비티가 화면에 나타나고 호출된다.")
    }

    override fun onPause()
    {
        println("3단계 : 액티비티가 사라지기 전에 호출 또는 반만 가려지거나 반투명상태에 호출됩니다.")
    }

    override fun onStop()
    {
        println("4단계 : 액티비티가 사라진 이후에 호출 됩니다.")
    }

    override fun onDestroy() {
        println("5단계 : 액티비티가 완전히 메모리에 제거 될때 호출 됩니다")
    }
}
