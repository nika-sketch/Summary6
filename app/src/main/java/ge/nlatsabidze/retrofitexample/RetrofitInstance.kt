package ge.nlatsabidze.retrofitexample

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val API: RetrofitApi by lazy {
        Retrofit.Builder().baseUrl("https://run.mocky.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
    }
}