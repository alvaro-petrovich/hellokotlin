package mx.edu.ittehuacan.hellokotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.i(localClassName, "onCreate, is new ${savedInstanceState == null}")
  }

  override fun onStart() {
    super.onStart()
    Log.i(localClassName, "onStart()")
  }

  override fun onRestart() {
    super.onRestart()
    Log.i(localClassName, "onRestart()")
  }

  override fun onResume() {
    super.onResume()
    Log.i(localClassName, "onResume()")
  }

  override fun onPause() {
    super.onPause()
    Log.i(localClassName, "onPause()")
  }

  override fun onStop() {
    super.onStop()
    Log.i(localClassName, "onStop()")
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i(localClassName, "onDestroy()")
  }

}