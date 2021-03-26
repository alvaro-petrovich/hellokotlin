package mx.edu.ittehuacan.hellokotlin.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import mx.edu.ittehuacan.hellokotlin.R
import mx.edu.ittehuacan.hellokotlin.databinding.ActivityLoginBinding
import mx.edu.ittehuacan.hellokotlin.main.CentralActivity

class LoginActivity : AppCompatActivity() {
  lateinit var binding: ActivityLoginBinding
  lateinit var viewModel: LoginViewModel;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    //setContentView(R.layout.activity_login)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    initViewModel()
  }

  private fun initViewModel() {
    val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
    viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
    binding.viewModel = viewModel
    binding.lifecycleOwner = this
    viewModel.login.observe(this, {
      if ( it == true ) {
        Toast.makeText(this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show()
        CentralActivity.start(this)
        finish()
      } else {
        Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
      }
    })
    /*viewModel.pass.observe(this, {
      if ( it == "123456" ) {
        Toast.makeText(this, "Contraseña correcta", Toast.LENGTH_SHORT).show()
      } else {
        Toast.makeText(this, R.string.password_error, Toast.LENGTH_LONG).show()
      }
    })*/
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