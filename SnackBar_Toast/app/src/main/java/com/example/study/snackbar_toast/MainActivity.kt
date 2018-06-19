package com.example.study.snackbar_toast

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_toast.setOnClickListener {
            Toast.makeText(this, "토스트 메세지", Toast.LENGTH_LONG).show()
        }

        btn_snack_bar.setOnClickListener {
            Snackbar.make(main_view, "스낵바 메세지", Snackbar.LENGTH_LONG).show()
        }
    }
}
