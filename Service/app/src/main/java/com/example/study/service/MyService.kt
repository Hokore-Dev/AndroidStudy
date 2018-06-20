package com.example.study.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service()
{
    override fun onBind(intent: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // 서비스 생성 될 때
    override fun onCreate() {
        super.onCreate()
    }

    // 생성되기 직전에 작동
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread {
            run {
                while (true){
                    Thread.sleep(3000)
                    println("서비스 실행중 입니다.")
                }
            }
        }.start()
        return START_STICKY
    }

    // 서비스가 제거 될 때 작동
    override fun onDestroy() {
        super.onDestroy()
    }
}