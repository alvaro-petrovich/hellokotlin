package mx.edu.ittehuacan.hellokotlin.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mx.edu.ittehuacan.hellokotlin.database.HelloKotlinDB

class SplashViewModel(application: Application) : AndroidViewModel(application) {

  private val _existsUser = MutableLiveData<Boolean>()
  val existsUser: LiveData<Boolean> get() = _existsUser

  private val _progressVisibility = MutableLiveData<Boolean>()
  val progressVisibility: LiveData<Boolean> get() = _progressVisibility

  fun checkUser() {
    viewModelScope.launch {
      _progressVisibility.value = true
      _existsUser.value = withContext( Dispatchers.IO ) {
        val userDAO = HelloKotlinDB.getInstance( getApplication() ).userDAO()
        userDAO.count() > 0
      }
      _progressVisibility.value = false
    }
  }

}