package mx.edu.ittehuacan.hellokotlin.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import mx.edu.ittehuacan.hellokotlin.BaseActivity
import mx.edu.ittehuacan.hellokotlin.R
import mx.edu.ittehuacan.hellokotlin.databinding.ActivityRegisterBinding
import mx.edu.ittehuacan.hellokotlin.splash.SplashViewModel

class RegisterActivity : BaseActivity() {
  lateinit var binding: ActivityRegisterBinding
  lateinit var viewModel: RegisterViewModel;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    //setContentView(R.layout.activity_register)
    //ActivityLoginBinding.inflate( layoutInflater ).apply { setContentView( root ) }
    /*val reference = ActivityRegisterBinding.inflate( layoutInflater )
    setContentView( reference.root )*/
    binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
    initViewModel()
  }

  private fun initViewModel() {
    val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
    viewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
    binding.model = viewModel
    binding.lifecycleOwner = this
    viewModel.userCreated.observe(this, Observer {
      log( "O User Created: $it" )
    })
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.register_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if ( item.itemId == R.id.save_register ) {
      Toast.makeText(this, getString(R.string.toast_save_register), Toast.LENGTH_SHORT).show()
      //finish()
      viewModel.save( binding.textInputName.text.toString(), binding.textInputLastName.text.toString() )
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