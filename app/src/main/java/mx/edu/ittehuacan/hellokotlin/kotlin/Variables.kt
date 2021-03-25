package mx.edu.ittehuacan.hellokotlin.kotlin

import java.lang.NullPointerException

const val HELLO = "HOLA!"

fun main( args: Array<String> ) {
  println( "¡Bienvenido a Kotlin!" )
  //varVal()
  //checkNull();
  //checkString()
  //checkConversions()
  //checkNullSafety()
  //checkIf( args[0] )
  //checkFor();
  //checkWhileDoWhile()
  //checkForEach()
  //checkBreakContinueLabels()
  //checkArrays()
  //checkFun()
  //checkLambda()
  checkClass()
}

fun checkClass() {
  val cell = Cell()
  println( "Estatus del cell: ${cell.getStatus()}" )
  cell.updateIMEI( "1234567890" )
  cell.number = "0987654321"
  cell.owner = "Moctezuma"
  println( "Estatus del cell: ${cell.getStatus()}" )
  println( "Cell: $cell" )
  val player = Player( "Alvaro", 35 )
  println( "Player: $player" )
}

fun checkLambda() {
  // forma 1, sin parámetros, asignada a una variable
  val hi = { println( "Hola" ) }
  hi()
  // forma 2, con parámetros, asignada a una variable
  val bye = { name: String -> println( "Adiós $name" ) }
  bye( "Alvaro" )
  // forma 3, sin asignar a una variable
  val name = "Juan"
  println( "Ejecutando lambda sin parámetros: ${ { "Nombre anterior: $name" }() }" )
  println( "Ejecutando lambda con parámetros: ${ { a: Int, b: Int -> a + b }( 15, 17 ) }" )
}

fun checkFun() {
  println( "Mensaje: ${validateData( 3, 5)}" )
  println( "Mensaje: ${validateData( 3 )}" )
  println( "Mensaje: ${validateData()}" )
  // parámetros por default nombrados
  println( "Mensaje: ${validateData( b = 3 )}" )
}

// parámetros con valor por default
fun validateData( a: Int = 1, b: Int = 6 ) = "Números validados: $a & $b"

//fun validateData( a: Int, b: Int ) = "Números validados: $a & $b"

/*fun validateData( a: Int, b: Int ): String {
  return "Números validados: $a & $b"
}*/

fun checkArrays() {
  val enteros = intArrayOf( 7,8,5,9,10,3 )
  //val objects = arrayOf( 1,2,3 )
  val objects = arrayListOf( 1,2,3 )
  //objects.a
  var sum = 0.0
  var counter = 0.0
  for ( calificacion in enteros ) {
    sum += calificacion
    counter++
  }
  println( "Número de calificaciones: ${counter}" )
  println( "Suma de calificaciones: ${sum}" )
  println( "Promedio de calificaciones: ${sum/counter}" )
  println( "Usando métodos de Array Int" )
  println( "Número de calificaciones: ${enteros.size}" )
  println( "Suma de calificaciones: ${enteros.sum()}" )
  println( "Promedio de calificaciones: ${enteros.sum()/enteros.size}" )
  println( "Promedio de calificaciones: ${enteros.average()}" )
  println( "Array al revés: ${enteros.reversedArray().toList()}" )
  enteros.reverse()
  println( "Array al revés: ${enteros.toList()}" )
  enteros.reverse()
  println( "Array al revés del revés, es decir, el original: ${enteros.toList()}" )
  val mutableList = mutableListOf( 1,8,5 )
  println( "List m = $mutableList" )
  mutableList.add( 10 )
  println( "List m = $mutableList" )
}

fun checkBreakContinueLabels() {
  for ( i in 1 until 4 ) {
    println( "i = $i" )
    for ( j in 1 until 5 ) {
      if ( j == 3 ) break
      println( "  j = $j" )
    }
  }
  for ( i in 1 until 4 ) {
    println( "i = $i" )
    for ( j in 1 until 5 ) {
      if ( j == 3 ) continue
      println( "  j = $j" )
    }
  }
  mainFor@for ( i in 1 until 3 ) {
    println( "MF i = $i" )
    secondFor@for ( j in 1 until 3 ) {
      println( "  SF j = $j" )
      for ( k in 1 until 5 ) {
        if ( k == 3 ) break@mainFor// rompe el ciclo mainFor
        println( "    TF k = $k" )
      }
    }
  }
  mainFor@for ( i in 1 until 3 ) {
    println( "CMF i = $i" )
    secondFor@for ( j in 1 until 3 ) {
      println( "  CSF j = $j" )
      for ( k in 1 until 5 ) {
        if ( k == 3 ) continue@mainFor// continua con la siguiente iteración del mainFor
        println( "    CTF k = $k" )
      }
    }
  }
  println( "Labels - ForEach" )
  listOf( 1,2,3,4 ).forEach lit@{
    if ( it == 3 ) {
      return@lit
    }
    println( "ForEach: $it" )
  }
  println( "Fin del ForEach" )
}

fun checkForEach() {
  val numberRange = 10..20
  numberRange.forEach {
    println( "It: $it" )
  }
  val list = mutableListOf( "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" )
  list.forEach {
    println( "Día de la semana: $it" )
  }
}

fun checkWhileDoWhile() {
  var i = 1
  while ( i < 11 ) {
    println( "While.i = $i" )
    i++
  }
  i = 10
  do {
    println( "Do-While.i = $i" )
    i--
  } while ( i > 0 )
}

fun checkFor() {
  val rangoEntero = 10..100
  val rangoCadena = 'A'..'F'
  for ( entero in rangoEntero ) {
    println( "Entero: $entero" )
  }
  for ( caracter in rangoCadena ) {
    println( "Caracter: $caracter" )
  }
  for ( (indice, caracter) in rangoCadena.withIndex() ) {
    println( "Caracter $indice: $caracter" )
  }
  for ( entero in 1..5 ) {
    println( "Entero: $entero" )
  }
  for ( entero in 1 until 10 step 3 ) {
    println( "Entero: $entero" )
  }
  for ( entero in 1 until 10 step 3 ) {
    println( "Entero: $entero" )
  }
  for ( entero in 100 downTo 20 step 5 ) {
    println( "Entero down: $entero" )
  }
  val list = listOf( "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" )
  println( list[1] )
  for ( index in list.indices ) {
    println( "Índice $index = ${ list[index] }" )
  }
}

fun checkIf( val1: String ) {
  var number = val1.toInt()
  if ( number > 10 ) {
    println( "El número $number es mayor a 10" )
  } else {
    println( "El número $number no es mayor a 10" )
  }
  //boolean mayor = number > 10 ? true : false; // Java
  val message = if ( number > 10 ) "Número mayor a 10" else "Número no mayor a 10"
  println( message )
  when {
    number > 10 -> println( "El número $number es mayor a 10" )
    number == 10 -> println( "El número $number es igual a 10" )
    else -> println( "El número $number es menor a 10" )
  }
  number = 1
  when ( number ) {
    1 -> println( "Es 1" )
    in 2..9 -> print( "Está dentro del 2 al 9" )
    10,11,12 -> println( "Es 10, 11 o 12" )
    else -> println( "Es mayor a 12" )
  }
  val result =
    when ( number ) {
      1 -> "Es 1"
      in 2..9 -> "Está dentro del 2 al 9"
      10,11,12 -> "Es 10, 11 o 12"
      else -> "Es mayor a 12"
    }
  println( "Resultado: $result" )
  val rangoEntero = 10..100
  val rangoCadena = 'A'..'F'
}

fun checkNullSafety() {
  var cadena: String? = null
  println( "Número de caracteres: ${cadena?.length}" )
  println( "Número de caracteres: ${cadena?.length ?: 0}" )
  try {
    println( "Número de caracteres: ${cadena!!.length}" )
  //} catch ( e: NullPointerException )
  } catch ( e: Exception ) {
    println( "Ocurrió un excepción: $e" )
    e.printStackTrace()
  }
}

fun checkConversions() {
  val entero = 9
  val doble = 10.1
  val caracter = 'v'
  val cadena = "200"
  val bandera = true
  entero.toString()
  println( "$cadena = ${cadena.toInt()}" )
}

fun checkString() {
  val name = "Alvaro"
  val lastName = "Cid"
  val age = 35
  println( "Nombre completo: $name $lastName\nEdad: $age años" )
  println( "Nombre: $name" )
  //name.length
  println( "Tamaño del nombre $name = ${name.length} caracteres \$name" )
  val raw = """Hola, soy un salto de línea\nJejeje"""
  println( raw )
  val ident = """
    Un párrafo enorme,
    esta es la segunda línea
    y esta es la tercera
  """.trimIndent()
  println( ident )
  val ident2 = """
    Un párrafo enorme,
    esta es la segunda línea
    y esta es la tercera
  """
  println( ident2 )
}

fun checkNull() {
  var nulo: String? = null
  println( nulo )
}

fun varVal() {
    // var si puede cambiarse
    var i: Int = 10
    var j = 5
    println( i )
    i = 20
    println( i )
    // val no puede cambiar su valor
    val y: Int = 30
    println( y )
    //y = 40
}
