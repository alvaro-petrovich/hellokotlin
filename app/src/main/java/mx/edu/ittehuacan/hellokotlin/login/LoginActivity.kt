package mx.edu.ittehuacan.hellokotlin.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.edu.ittehuacan.hellokotlin.R

class LoginActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)
  }

  companion object {// para manejar métodos o variables estáticas
    fun start( context: Context) {
      Intent( context, LoginActivity::class.java ).apply {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(this)
      }
    }
  }
}