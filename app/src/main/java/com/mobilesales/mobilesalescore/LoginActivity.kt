package com.mobilesales.mobilesalescore

import android.content.Intent
import androidx.biometric.BiometricPrompt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_login.*
import java.util.concurrent.Executor

class LoginActivity : AppCompatActivity() {

    private var usuario     : String = ""
    private var senha       : String = ""

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val ttl = AnimationUtils.loadAnimation(this, R.anim.login_anim_logo)
        val ttc = AnimationUtils.loadAnimation(this, R.anim.login_anim_credentials)
        login_app_logo.startAnimation(ttl)
        login_card_view_credentials.startAnimation(ttc)

        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(applicationContext,"Authentication error: $errString", Toast.LENGTH_SHORT).show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    openSystem()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(applicationContext, "Autenticação falhou",Toast.LENGTH_SHORT).show()
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Login Biométrico")
            .setSubtitle("faça login com a sua digital.")
            .setNegativeButtonText("Usar a senha da conta")
            .build()

        //Listener de abertura da biometria
        login_btn_fingerprint.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }

        initListeners()
    }

    private fun initListeners(){
        login_btn_login.setOnClickListener {
            usuario = editTextUsuario.editText?.text.toString()
            senha   = editTextSenha.editText?.text.toString()
            logar(usuario, senha)
        }

        login_btn_forget.setOnClickListener {
            Toast.makeText(baseContext, "Esqueceu a senha?", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Método para fazer o login
     **/
    private fun logar(user : String, senha : String){
        if (user == "123" && senha == "123"){
            Toast.makeText(baseContext, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
            openSystem()
        }else{
            Toast.makeText(baseContext, "Erro ao Logar.", Toast.LENGTH_SHORT).show()
        }
    }

    fun openSystem(){
        val intent = MainActivity.newIntent(this)
        startActivity(intent)
    }

}
