package com.example.study.webview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.naver.com")

        button_naver.setOnClickListener {
            webView.loadUrl("https://www.naver.com")
        }

        button_daum.setOnClickListener {
            webView.loadUrl("https://www.daum.net")
        }

        button_google.setOnClickListener {
            webView.loadUrl("https://google.com")
        }
    }
}
