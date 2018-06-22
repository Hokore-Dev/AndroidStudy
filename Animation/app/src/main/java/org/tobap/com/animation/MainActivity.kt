package org.tobap.com.animation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_fadein.setOnClickListener {
            var anim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            text_fadein.startAnimation(anim)
        }

        button_fadeout.setOnClickListener {
            var anim = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            text_fadeout.startAnimation(anim)
        }
    }
}
