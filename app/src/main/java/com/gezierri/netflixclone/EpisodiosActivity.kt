package com.gezierri.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_episodios.*

class EpisodiosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodios)
        supportActionBar?.hide()

        val videoFirebase = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-67ae3.appspot.com/o/video.jpg?alt=media&token=b22e7669-27b8-498d-88e1-1682102af180")
        Picasso.get().load(videoFirebase).into(video)

        video.setOnClickListener {
            intent = Intent(this, VideoActivity::class.java)
            startActivity(intent  )
        }
    }
}