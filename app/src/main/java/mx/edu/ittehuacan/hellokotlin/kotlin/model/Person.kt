package mx.edu.ittehuacan.hellokotlin.kotlin.model

abstract class Person(
  val name: String,
  val lastName: String,
  var age: Int
) {
  override fun toString(): String {
    return "Nombre: $name, Apellido: $lastName, Edad: $age años"
  }
}