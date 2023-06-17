package org.d3if0144.myapplication.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "AldiNugraha02/Asessmen2-Mobpro/master/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("copyright.json")
    suspend fun getCopyright(): String
}
object KalkulatorApi {
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }
