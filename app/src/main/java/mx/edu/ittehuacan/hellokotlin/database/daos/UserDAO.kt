package mx.edu.ittehuacan.hellokotlin.database.daos

import androidx.room.*
import mx.edu.ittehuacan.hellokotlin.database.entities.User

@Dao
interface UserDAO {

  @Insert
  fun insert( user: User )

  @Delete
  fun delete( user: User )

  @Update
  fun update( user: User )

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun save( user: User )

  @Query("SELECT * FROM users")
  fun selectAll(): List<User>

  @Query("SELECT * FROM users WHERE user_id = :id")
  fun selectByID( id: Int )

}