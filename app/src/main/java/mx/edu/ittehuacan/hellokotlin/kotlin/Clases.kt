package mx.edu.ittehuacan.hellokotlin.kotlin

import mx.edu.ittehuacan.hellokotlin.kotlin.model.Animal
import mx.edu.ittehuacan.hellokotlin.kotlin.model.Employee
import mx.edu.ittehuacan.hellokotlin.kotlin.model.Student

fun main() {
  val luis = Employee("Luis","Pérez",28,"Google")
  //luis.name = "Juan"// error, no se puede reasignar un tipo val
  luis.age = 29
  val maria = Student("María","Ruíz",20,"ITTehuacan")
  //maria.schoolSubjects = mutableSetOf()// error, setter es privado
  maria.addSchoolSubject( "Fundamentos de programación" )
  maria.addSchoolSubject( "Introducción a la ISC" )
  maria.addSchoolSubject( "Física I" )
  println( "Empleado: $luis" )
  println( "Estudiante: $maria" )

  val perro = Animal( "Scooby Doo", "Perro parlante", true )
  println( "Animal => $perro" )

  luis.play()
  luis.injured()
}
