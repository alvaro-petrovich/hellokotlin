package mx.edu.ittehuacan.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  var counter = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)// indico la pantalla a usar
    // TODO inicializar variables
    /*val text = findViewById<TextView>(R.id.textHello)
    text.text = "Bienvenido a Android con Kotlin"*/
    //textHello.text = "Elemento importado con kotlinx"
    val updater = { v: View ->
      counter++
      //buttonHello.text = "Presionado: $counter"
      textHello.text = "¡Hola ${editName.text}!"
      Log.d("MainActivity", "Elemento presionado $v")
      //v.text = "Presionado: $counter"// error
      if ( v is TextView ) {// al preguntar por el tipo
        //((TextView) v).setText( "1234567890" );// Java
        v.text = "Presionado: $counter"
      } else if ( v is Button ) {
        v.text = "Presionado: $counter"
      }
    }
    textHello.setOnClickListener(updater)
    buttonHello.setOnClickListener(updater)
    /*buttonHello.setOnClickListener {
      counter++
      //buttonHello.text = "Presionado: $counter"
      textHello.text = "¡Hola ${editName.text}!"
      Log.d("MainActivity", "Elemento presionado $it")
    }*/
  }
}