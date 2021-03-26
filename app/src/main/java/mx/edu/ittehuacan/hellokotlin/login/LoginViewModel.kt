package mx.edu.ittehuacan.hellokotlin.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mx.edu.ittehuacan.hellokotlin.main.CentralActivity

class LoginViewModel(application: Application) : AndroidViewModel(application) {
  val user = MutableLiveData<String>()
  //val user: LiveData<String> get() = _user

  val pass = MutableLiveData<String>()
  //val pass: LiveData<String> get() = _pass

  private val _login = MutableLiveData<Boolean>()
  val login: LiveData<Boolean> get() = _login

  //activity_login.xml
  //android:onClick="@{ () -> viewModel.doLogin( textUsername.text.toString(), textPassword.text.toString() ) }"
  fun doLogin() {
    Log.d("LoginViewModel", "U: ${user.value}")
    Log.d("LoginViewModel", "P: ${pass.value}")
    _login.value = user.value == "admin" && pass.value == "123456"
  }

}