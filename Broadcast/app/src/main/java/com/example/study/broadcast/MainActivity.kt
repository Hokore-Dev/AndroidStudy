package com.example.study.broadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myBroadcastReceiver = MyBroadCastReceiver()
    var intentFilter = IntentFilter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_camera.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
            sendBroadcast(Intent(Intent.ACTION_CAMERA_BUTTON))
        }
    }

    override fun onResume() {
        super.onResume()

        // 배터리 부족
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW)

        // 네트워크 상태
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")

        // 문자 수신
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED")

        // 카메라 버튼
        intentFilter.addAction(Intent.ACTION_CAMERA_BUTTON)

        // 날짜 변경
        intentFilter.addAction(Intent.ACTION_DATE_CHANGED)

        // 비행기 모드
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        // 샷 다운
        intentFilter.addAction(Intent.ACTION_SHUTDOWN)

        // 매분 마다 수신
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        registerReceiver(myBroadcastReceiver, intentFilter)
    }
}
