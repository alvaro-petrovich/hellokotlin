package mx.edu.ittehuacan.hellokotlin.database.daos

import androidx.room.Dao
import androidx.room.Query
import mx.edu.ittehuacan.hellokotlin.database.BaseDAO
import mx.edu.ittehuacan.hellokotlin.database.entities.Pet

@Dao
abstract class PetDAO : BaseDAO<Pet>() {

  @Query("SELECT * FROM pets")
  abstract suspend fun selectAll(): List<Pet>

}