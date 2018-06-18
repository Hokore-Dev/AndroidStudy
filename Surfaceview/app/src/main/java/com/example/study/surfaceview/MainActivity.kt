package com.example.study.surfaceview

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.SurfaceHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , SurfaceHolder.Callback, MediaPlayer.OnPreparedListener{



    var surfaceHolder : SurfaceHolder? = null
    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        surfaceHolder = surfaceView.holder
        surfaceHolder!!.addCallback(this)

        back.setOnClickListener {
            var position = mediaPlayer!!.currentPosition - 5000
            mediaPlayer!!.seekTo(position)
        }

        fast.setOnClickListener {
            var position = mediaPlayer!!.currentPosition + 5000
            mediaPlayer!!.seekTo(position)
        }

        stop.setOnClickListener {
            mediaPlayer!!.pause()
        }

        play.setOnClickListener {
            mediaPlayer!!.start()
        }
    }

    // 서피스 변경에 따른 콜백
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
    }

    // 서피스 종료/ 삭제
    override fun surfaceDestroyed(holder: SurfaceHolder?) {
    }

    // 서피스 뷰 생성시
    override fun surfaceCreated(holder: SurfaceHolder?) {
        var url = "https://www.rmp-streaming.com/media/bbb-360p.mp4"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDisplay(holder)
        mediaPlayer!!.setDataSource(url)
        mediaPlayer!!.prepare()
        mediaPlayer!!.setOnPreparedListener(this)
    }

    // 영상 준비 완료시
    override fun onPrepared(mp: MediaPlayer?) {
        mediaPlayer!!.start()
    }
}
