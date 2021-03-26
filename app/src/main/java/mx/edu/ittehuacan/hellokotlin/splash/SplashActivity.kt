package mx.edu.ittehuacan.hellokotlin.splash

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import mx.edu.ittehuacan.hellokotlin.BaseActivity
import mx.edu.ittehuacan.hellokotlin.R
import mx.edu.ittehuacan.hellokotlin.login.LoginActivity
import mx.edu.ittehuacan.hellokotlin.register.RegisterActivity

class SplashActivity : BaseActivity() {
  private lateinit var viewModel: SplashViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.MySplashStyle)
    super.onCreate(savedInstanceState)
    initViewModel()
  }

  private fun initViewModel() {
    val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
    viewModel = ViewModelProvider(this, factory).get(SplashViewModel::class.java)
    viewModel.progressVisibility.observe(this, Observer {
      log( "O Progress: $it" )
    })
    viewModel.existsUser.observe(this, Observer {
      log( "O Exists user? $it" )
      if ( it == true ) {
        goToLoginActivity()
      } else {
        goToRegisterActivity()
      }
    } )
  }

  //fun

  override fun onResume() {
    super.onResume()
    viewModel.checkUser()
  }

  private fun goToRegisterActivity() {
    RegisterActivity.start( this )
    finish()
  }

  private fun goToLoginActivity() {
    LoginActivity.start( this )
    finish()
  }


  /*private fun thereIsUser() : Boolean {
    var existUser = false
    lifecycleScope.launch {
      val users = db.userDAO().selectAll()
      Log.d(localClassName, "Users size: ${users.size}")
      existUser = users.size > 1
    }
    return existUser
  }*/

}