package com.gezierri.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tela_principal.*

class TelaPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        val serie = serie1
        val imagens = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-67ae3.appspot.com/o/witcher.png?alt=media&token=df0d7ec0-0538-47b3-9ce0-4d23506ef44e")

        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie1)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie2)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie3)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie4)

        serie.setOnClickListener {
            intent = Intent(this, EpisodiosActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater =  menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
                R.id.menu_sair ->{
                    FirebaseAuth.getInstance().signOut()
                    loginActivity()
                    finish()
                    true
                }
            else -> return super.onOptionsItemSelected(item)
        }

    }

    private fun loginActivity(){
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}