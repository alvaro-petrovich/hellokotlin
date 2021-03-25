package mx.edu.ittehuacan.hellokotlin.splash

import android.os.Bundle
import android.os.Handler
import mx.edu.ittehuacan.hellokotlin.BaseActivity
import mx.edu.ittehuacan.hellokotlin.R
import mx.edu.ittehuacan.hellokotlin.register.RegisterActivity

class SplashActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.MySplashStyle)
    super.onCreate(savedInstanceState)
    Handler().postDelayed({
      if ( !thereIsUser() ) {
        goToRegisterActivity()
      }
    }, 1000)
  }

  private fun goToRegisterActivity() {
    RegisterActivity.start( this )
    finish()
  }

  private fun thereIsUser() = false

}