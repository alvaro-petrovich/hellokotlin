package mx.edu.ittehuacan.hellokotlin.database.daos

import androidx.room.*
import mx.edu.ittehuacan.hellokotlin.database.entities.User

@Dao
interface UserDAO {

  @Insert
  suspend fun insert( user: User )

  @Delete
  suspend fun delete( user: User )

  @Update
  suspend fun update( user: User )

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun save( user: User )

  @Query("SELECT * FROM users")
  suspend fun selectAll(): List<User>

  @Query("SELECT * FROM users WHERE user_id = :id")
  suspend fun selectByID( id: Int ): User

  @Query("SELECT * FROM users WHERE user_name = :name")
  suspend fun selectByName( name: String ): User

  @Query("SELECT count(1) FROM users")
  suspend fun count(): Int
}