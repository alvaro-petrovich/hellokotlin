package mx.edu.ittehuacan.hellokotlin.kotlin.model

class Student(
  name: String,
  lastName: String,
  age: Int,
  var school: String
) : Person(name, lastName, age) {
  lateinit var schoolSubjects: MutableSet<String>
  private set

  init {
    schoolSubjects = mutableSetOf()
  }

  fun addSchoolSubject( schoolSubject: String ) {
    schoolSubjects.add( schoolSubject )
  }

  override fun toString(): String {
    return "${super.toString()}, Escuela: $school, Materias: $schoolSubjects"
  }

}