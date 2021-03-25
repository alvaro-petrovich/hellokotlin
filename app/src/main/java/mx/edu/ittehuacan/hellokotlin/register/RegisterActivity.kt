package mx.edu.ittehuacan.hellokotlin.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import mx.edu.ittehuacan.hellokotlin.BaseActivity
import mx.edu.ittehuacan.hellokotlin.R

class RegisterActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_register)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.register_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if ( item.itemId == R.id.save_register ) {
      finish()
      return true
    }
    return super.onOptionsItemSelected(item)
  }

  /*
  * val intent = Intent(this, RegisterActivity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    startActivity(intent)
  *  */
  companion object {// para manejar métodos o variables estáticas
    fun start( context: Context ) {
      Intent( context, RegisterActivity::class.java ).apply {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(this)
      }
    }
  }

}