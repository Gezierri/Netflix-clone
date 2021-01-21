package com.gezierri.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagemLogo = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-67ae3.appspot.com/o/logo.png?alt=media&token=9b09f3c9-5614-4652-a8ac-d2ec0ce7b593")
        Picasso.get().load(imagemLogo).into(imageView)

        supportActionBar?.hide()
        Handler().postDelayed({abrirTelaLogin()}, 2000)

    }

    private fun abrirTelaLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }


}