package com.gezierri.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        supportActionBar?.hide()

        btnCadastrar.setOnClickListener {
            cadastrar()
        }
    }

    private fun cadastrar() {

        var email = editTextEmail.text.toString()
        var senha = editTextSenha.text.toString()

        if (email.isNotEmpty()) {
            if (senha.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            toast("Cadastro efetuado com sucesso")
                            loginActivity()
                            finish()
                        }
                    }.addOnFailureListener {
                        var erro = it
                        when (erro) {
                            is FirebaseAuthInvalidCredentialsException -> toast("Digite um e-mail válido")
                            is FirebaseAuthWeakPasswordException -> toast("Digite uma senha mais forte")
                            is FirebaseAuthUserCollisionException -> toast("E-mail já cadastrado")
                            is FirebaseNetworkException -> toast("Sem conexão com a internet")
                            else -> toast("Erro ao cadastrar usuário")
                        }
                    }
            } else {
                toast("Preencha os campo senha")
            }
        } else {
            toast("Preencha os campo e-mail")
        }
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun loginActivity(){
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}