package mx.edu.ittehuacan.hellokotlin

import android.app.Application
import androidx.room.Room
import mx.edu.ittehuacan.hellokotlin.database.HelloKotlinDB

class HelloKotlinApp : Application() {

  val db: HelloKotlinDB = Room.databaseBuilder(
    this, HelloKotlinDB::class.java,
    "hello_kotlin.db"
  ).build()

}