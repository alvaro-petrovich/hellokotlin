package mx.edu.ittehuacan.hellokotlin.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import mx.edu.ittehuacan.hellokotlin.BaseActivity
import mx.edu.ittehuacan.hellokotlin.R

class CentralActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_central)
  }

  fun callToFEPADE( v: View ) {
    //Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "Your Phone_number"));
    //startActivity(intent);
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:55 5346 0000"))
    startActivity( intent )
  }

  fun callWebService(v: View ) {
    log( "Vamos a consumir un web service usando Retrofit" )
    val consumer = Consumer()

    Thread {
      consumer.call()
    }.start()

  }

  companion object {// para manejar métodos o variables estáticas
    fun start( context: Context) {
      Intent( context, CentralActivity::class.java ).apply {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(this)
      }
    }
  }
}