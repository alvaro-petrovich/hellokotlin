package mx.edu.ittehuacan.hellokotlin.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mx.edu.ittehuacan.hellokotlin.database.entities.User

class RegisterViewModel(application: Application) : AndroidViewModel(application) {
  private val repository = RegisterRepository( application )

  private val _userCreated = MutableLiveData<Boolean>()
  val userCreated: LiveData<Boolean> get() = _userCreated

  fun save( name: String, lastName: String ) {
    val user = User( 1, name, lastName )
    viewModelScope.launch {
      _userCreated.value = withContext( Dispatchers.IO ) {
        repository.create( user )
      }
    }
  }

}