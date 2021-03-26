package mx.edu.ittehuacan.hellokotlin

import android.app.Application
import androidx.room.Room
import mx.edu.ittehuacan.hellokotlin.database.HelloKotlinDB
@Deprecated("")
class HelloKotlinApp : Application() {

  override fun onCreate() {
    super.onCreate()
  }

  var db: HelloKotlinDB = Room.databaseBuilder(
    this, HelloKotlinDB::class.java,
    "hello_kotlin.db"
  ).build()

}