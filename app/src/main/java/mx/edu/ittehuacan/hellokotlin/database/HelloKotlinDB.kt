package mx.edu.ittehuacan.hellokotlin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import mx.edu.ittehuacan.hellokotlin.database.daos.UserDAO
import mx.edu.ittehuacan.hellokotlin.database.entities.User

@Database(
  version = 1,
  entities = [ User::class ]
)
abstract class HelloKotlinDB : RoomDatabase() {

  abstract fun userDAO(): UserDAO
}