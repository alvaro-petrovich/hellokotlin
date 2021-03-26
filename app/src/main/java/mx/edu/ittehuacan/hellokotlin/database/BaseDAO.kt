package mx.edu.ittehuacan.hellokotlin.database

import androidx.room.*
import mx.edu.ittehuacan.hellokotlin.database.entities.User

@Dao
abstract class BaseDAO<T> {
  @Insert
  abstract suspend fun insert( entity: T)

  @Delete
  abstract suspend fun delete( entity: T)

  @Update
  abstract suspend fun update( entity: T)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  abstract suspend fun save( entity: T)

}