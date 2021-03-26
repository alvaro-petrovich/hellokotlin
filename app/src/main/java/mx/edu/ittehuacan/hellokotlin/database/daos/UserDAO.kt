package mx.edu.ittehuacan.hellokotlin.database.daos

import androidx.room.*
import mx.edu.ittehuacan.hellokotlin.database.BaseDAO
import mx.edu.ittehuacan.hellokotlin.database.entities.User

@Dao
abstract class UserDAO : BaseDAO<User>() {

  @Query("SELECT * FROM users")
  abstract suspend fun selectAll(): List<User>

  @Query("SELECT * FROM users WHERE user_id = :id")
  abstract suspend fun selectByID( id: Int ): User

  @Query("SELECT * FROM users WHERE user_name = :name")
  abstract suspend fun selectByName( name: String ): User

  @Query("SELECT count(1) FROM users")
  abstract suspend fun count(): Int

}