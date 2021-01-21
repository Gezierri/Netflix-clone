package com.gezierri.netflixclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val videoFirebase = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-67ae3.appspot.com/o/videos%2FTHE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=51abc802-ad35-4ca4-b27d-82d2d7893d26")

        val decorView = window.decorView
        val opcoes = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = opcoes

        video.setMediaController(MediaController(this))
        video.setVideoURI(videoFirebase)
        video.requestFocus()
    }
}