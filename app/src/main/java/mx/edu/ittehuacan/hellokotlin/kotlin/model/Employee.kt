package mx.edu.ittehuacan.hellokotlin.kotlin.model

class Employee(
  name: String,
  lastName: String,
  age: Int,
  var job: String
) : Person(name, lastName, age), IPlayer {

  constructor(
    name: String,
    lastName: String,
    age: Int,
    job: String,
    player: Boolean
  ) : this(name, lastName, age, job){}

  override fun play() {
    println( "Estoy jugando" )
  }

  override fun injured(): Boolean {
    return false
  }

  override fun toString(): String {
    return "${super.toString()}, Trabajo: $job"
  }

}