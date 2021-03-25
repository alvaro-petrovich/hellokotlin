package mx.edu.ittehuacan.hellokotlin.kotlin

class Cell {
  private var imei = ""
  var number = ""
  get() {
    println( "Valor $field" )
    return field
  }
  set( value ) {
    println( "Valor actual: $field VS valor nuevo: $value" )
    field = value
  }
  var owner = ""

  fun updateIMEI( imei: String ) {
    this.imei = imei
  }

  fun getStatus(): String {
    return if ( imei == "" || number == "" || owner == "" ) {
      "Teléfono celular inservible"
    } else {
      "Teléfono celular OK"
    }
  }
}