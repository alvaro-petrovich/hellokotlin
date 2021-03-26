package mx.edu.ittehuacan.hellokotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.edu.ittehuacan.hellokotlin.database.daos.PetDAO
import mx.edu.ittehuacan.hellokotlin.database.daos.UserDAO
import mx.edu.ittehuacan.hellokotlin.database.entities.Pet
import mx.edu.ittehuacan.hellokotlin.database.entities.User

@Database(
  version = 2,
  entities = [ User::class, Pet::class ]
)
abstract class HelloKotlinDB : RoomDatabase() {

  abstract fun userDAO(): UserDAO

  abstract fun petDAO(): PetDAO

  companion object {
    @Volatile
    private var INSTANCE: HelloKotlinDB? = null

    fun getInstance( context: Context ): HelloKotlinDB {
      synchronized(this) {
        var instance = INSTANCE
        if ( instance == null ) {
          instance = Room.databaseBuilder(
            context.applicationContext,
            HelloKotlinDB::class.java,
            "hello_kotlin.db"
          )
            .fallbackToDestructiveMigration()
            .build()
          INSTANCE = instance
        }
        return instance
      }
    }
  }

}