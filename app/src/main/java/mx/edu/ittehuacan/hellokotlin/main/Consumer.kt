package mx.edu.ittehuacan.hellokotlin.main

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class Consumer {

  fun call(): String {
    val retrofit = Retrofit.Builder()
      .baseUrl( "http://api.divesites.com/" )
      .addConverterFactory(ScalarsConverterFactory.create())
      .build()
    val api = retrofit.create( IDiveSitesAPI::class.java )
    val call = api.getMyLocation()
    val result = call.execute()
    Log.d("Resultado WS", "=> $result")
    Log.d("Resultado WS", "=> ${result.body()}")
    return result.body() ?: "Sin respuesta"
  }

}