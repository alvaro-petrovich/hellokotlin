package mx.edu.ittehuacan.hellokotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    log("onCreate, is new ${savedInstanceState == null}")
  }

  override fun onStart() {
    super.onStart()
    log("onStart()")
  }

  override fun onRestart() {
    super.onRestart()
    log("onRestart()")
  }

  override fun onResume() {
    super.onResume()
    log("onResume()")
  }

  override fun onPause() {
    super.onPause()
    log("onPause()")
  }

  override fun onStop() {
    super.onStop()
    log("onStop()")
  }

  override fun onDestroy() {
    super.onDestroy()
    log("onDestroy()")
  }

  protected fun log( message: String ) {
    Log.i(localClassName, message)
  }

}