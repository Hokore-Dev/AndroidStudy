package com.example.study.requestpermission

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calendar = Manifest.permission.READ_CALENDAR
        var camera = Manifest.permission.CAMERA
        var contact  = Manifest.permission.READ_CONTACTS

        var location = Manifest.permission.ACCESS_FINE_LOCATION
        var microphone = Manifest.permission.RECORD_AUDIO
        var phone = Manifest.permission.READ_PHONE_STATE

        var sensor = Manifest.permission.BODY_SENSORS
        var sms = Manifest.permission.SEND_SMS
        var storage = Manifest.permission.READ_EXTERNAL_STORAGE

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(calendar, camera, contact, location, microphone, phone, sensor, sms, storage), 100)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100)
        {
            for (i in permissions.indices)
            {
                println("권한 :  " + permissions[i] + "허가 상태 : " + grantResults[i])
            }
        }
    }
}
