package mx.edu.ittehuacan.hellokotlin.main

import retrofit2.Call
import retrofit2.http.GET

interface IDiveSitesAPI {

  @GET("/")
  fun getMyLocation(): Call<String>

}