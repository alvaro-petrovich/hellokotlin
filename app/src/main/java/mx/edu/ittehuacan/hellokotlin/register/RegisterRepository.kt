package mx.edu.ittehuacan.hellokotlin.register

import android.app.Application
import mx.edu.ittehuacan.hellokotlin.database.HelloKotlinDB
import mx.edu.ittehuacan.hellokotlin.database.entities.User

class RegisterRepository( private val application: Application ) {
  private var dao = HelloKotlinDB.getInstance( application ).userDAO()

  suspend fun create( user: User ): Boolean {
    return try {
      dao.save( user )
      true
    } catch ( e: Exception ) {
      e.printStackTrace()
      false
    }
  }

}