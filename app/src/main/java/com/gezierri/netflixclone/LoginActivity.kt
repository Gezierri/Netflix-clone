package com.gezierri.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()
        verificarUsuario()

        txtInscrever.setOnClickListener {
            intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        btnEntrar.setOnClickListener {
            autenticacaoUsuario()
        }
    }

    private fun autenticacaoUsuario(){

        var email = editEmail.text.toString()
        var senha = editSenha.text.toString()

        if (preencherCampos()){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {
                if (it.isSuccessful){
                    toast("Login efetudo com sucesso!")
                    telaPrincipal()
                    finish()
                }
            }.addOnFailureListener {

                var erro = it
                when (erro){
                    is FirebaseAuthInvalidCredentialsException -> toast("Email ou senha incorretos")
                    is FirebaseNetworkException -> toast("Sem conexão com a internet")
                    else -> toast("Erro ao logar usuário")
                }
            }
        }
    }

    private fun toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun telaPrincipal(){
        intent = Intent(this, TelaPrincipalActivity::class.java)
        startActivity(intent)
    }

    private fun preencherCampos(): Boolean{

        var email = editEmail.text.toString()
        var senha = editSenha.text.toString()

        if (email.isNotEmpty()){
            if (senha.isNotEmpty()){
                return true
            }else{
                toast("Preencha o campo senha")
            }
        }else{
            toast("Preencha o campo email")
        }
        return false
    }

    private fun verificarUsuario(){

        var auth = FirebaseAuth.getInstance().currentUser

        if (auth != null){
            telaPrincipal()
        }
    }
}