package mx.edu.ittehuacan.hellokotlin.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
abstract class BaseDAO<T> {
  @Insert
  abstract suspend fun insert(user: T)

  @Delete
  abstract suspend fun delete( user: T)

  @Update
  abstract suspend fun update( user: T)
}