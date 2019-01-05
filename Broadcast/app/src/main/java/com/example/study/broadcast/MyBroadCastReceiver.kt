package com.example.study.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadCastReceiver : BroadcastReceiver()
{
    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent!!.action){
            Intent.ACTION_BATTERY_LOW -> Toast.makeText(context, "배터리가 없습니다", Toast.LENGTH_LONG).show()
        }
    }
}
