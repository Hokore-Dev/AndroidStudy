package com.example.study.sharedperference

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sharedPerferences = PreferenceManager.getDefaultSharedPreferences(this)
        var edit = sharedPerferences.edit()
        var save_string = sharedPerferences.getString("userId", "아이디를 입력해주세요")
        editText_email.setText(save_string)

        btn_save.setOnClickListener {
            edit.putString("user_id", editText_email.text.toString()).commit()
        }
    }
}
