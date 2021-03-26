package mx.edu.ittehuacan.hellokotlin.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity( tableName = "pets",
  foreignKeys = [ ForeignKey(entity = User::class,
    parentColumns = ["user_id"],
    childColumns = ["user_id"],
    onDelete = ForeignKey.CASCADE)
  ]
)
data class Pet(
  @PrimaryKey
  @ColumnInfo( name = "pet_name" )
  var name: String,
  @ColumnInfo( name = "pet_animal" )
  var animal: String,
  @ColumnInfo( name = "user_id" )
  var userID: Int
)
